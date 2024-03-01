package com.social.meli.service;

import com.social.meli.dto.request.PostDTO;
import com.social.meli.dto.response.PostDto;
import com.social.meli.dto.response.ProductDto;
import com.social.meli.dto.response.PublicationDto;
import com.social.meli.entity.Post;
import com.social.meli.entity.Product;
import com.social.meli.entity.User;
import com.social.meli.entity.UserType;
import com.social.meli.exception.InvalidDataException;
import com.social.meli.exception.NotFoundException;
import com.social.meli.repository.IPostRepository;
import com.social.meli.repository.IProductRepository;
import com.social.meli.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@Service
@AllArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    public static final AtomicInteger idCounter = new AtomicInteger(0);

    public int getAtomicInteger(){
        return idCounter.get();
    }
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
        User user = userRepository.findUserByUserId(post.getUserId()).orElseThrow(() -> new NotFoundException("No se encontro al usuario"));
        if (!UserType.VENDOR.equals(user.getType())) {
            throw new InvalidDataException("El usuario " + user.getName() + " no es un vendedor");
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
