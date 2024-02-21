package com.socialMeli.service;

import com.socialMeli.dto.request.PostDTO;
import com.socialMeli.dto.response.PostDto;
import com.socialMeli.dto.response.ProductDto;
import com.socialMeli.dto.response.PublicationDto;
import com.socialMeli.entity.Post;
import com.socialMeli.entity.Product;
import com.socialMeli.entity.User;
import com.socialMeli.exception.InvalidDataException;
import com.socialMeli.exception.NotFoundException;
import com.socialMeli.repository.IPostRepository;
import com.socialMeli.repository.IProductRepository;
import com.socialMeli.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.socialMeli.entity.UserType.VENDOR;


@Service
@AllArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    @Override
    public void addPost(PostDTO postDto) {
        validatePost(postDto);
        Post finalPost = new Post(idCounter.incrementAndGet(), postDto);
        if (productRepository.getProductById(postDto.getProduct().getId()).isEmpty()) {
            productRepository.add(convertProductDtoToEntity(postDto.getProduct()));
        }
        postRepository.add(finalPost);
    }

    @Override
    public PublicationDto obtainLastPublicationsByTheFollowedVendors(Integer userId, String order) {
        List<Integer> followedVendors = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new NotFoundException("No se encontro al usuario"))
                .getFollowedId();

        List<Post> latestPost = new ArrayList<>();
        for (Integer vendorId : followedVendors) {
            Optional<List<Post>> filteredPostOfOneUser = postRepository.getPostFromTheLastTwoWeeksByUserId(vendorId);
            filteredPostOfOneUser.ifPresent(latestPost::addAll);
        }
        return new PublicationDto(userId, sortPostsByDate(addRecoverProductsDtoOnPosts(latestPost), order));
    }

    private List<PostDto> addRecoverProductsDtoOnPosts(List<Post> postList) {
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : postList) {
            PostDto postDto = convertPostToDto(post);
            postDto.setProduct(
                    convertProductToDto(
                            productRepository.getProductById(post.getProductId())
                                    .orElseThrow(() -> new NotFoundException("No se encontro el producto")))
            );
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    private void validatePost(PostDTO post) {
        if (post.getUserId() <= 0) {
            throw new InvalidDataException("Error al enviar los datos: Usuario no válido");
        }
        User user = userRepository.findUserByUserId(post.getUserId()).orElseThrow(() -> new NotFoundException("No se encontro al usuario"));
        if (!VENDOR.equals(user.getType())) {
            throw new InvalidDataException("El usuario " + user.getName() + " no es un vendedor");
        }
        if (post.getDate() == null) {
            post.setDate(LocalDate.now());
        }
        if (post.getProduct() == null
                || post.getProduct().getName() == null
                || post.getProduct().getId() <= 0
                || post.getProduct().getName().isEmpty()) {
            throw new InvalidDataException("Error al enviar los datos: Producto no válido");
        }
        if (post.getCategory() <= 0) {
            throw new InvalidDataException("Error al enviar los datos: Categoría no válida");
        }
        if (post.getPrice() <= 0) {
            throw new InvalidDataException("Error al enviar los datos: Precio no válido");
        }
    }

    private List<PostDto> sortPostsByDate(List<PostDto> posts, String order) {
        List<PostDto> defaultSortedList = posts.stream()
                .sorted(Comparator.comparing(PostDto::getDate).reversed())
                .toList();
        if (order != null) {
            switch (order) {
                case "date_asc" -> {
                    return posts.stream()
                            .sorted(Comparator.comparing(PostDto::getDate))
                            .toList();
                }
                case "date_desc" -> {
                    return defaultSortedList;
                }
                default -> throw new InvalidDataException("Los datos de ordenamiento solicitados son incorrectos.");
            }
        }
        return defaultSortedList;
    }

    private PostDto convertPostToDto(Post post) {
        PostDto convertedPost = new PostDto();
        convertedPost.setUserId(post.getUserId());
        convertedPost.setId(post.getId());
        convertedPost.setDate(post.getDate());
        convertedPost.setPrice(post.getPrice());
        convertedPost.setCategory(post.getCategory());
        return convertedPost;
    }

    private ProductDto convertProductToDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNote()
        );
    }

    private Product convertProductDtoToEntity(ProductDto product) {
        return new Product(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNote()
        );
    }
}
