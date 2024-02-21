package com.social.meli.service;

import com.social.meli.dto.request.PromoPostDto;
import com.social.meli.dto.response.*;
import com.social.meli.entity.Post;
import com.social.meli.entity.Product;
import com.social.meli.entity.PromoPost;
import com.social.meli.entity.User;
import com.social.meli.exception.InvalidDataException;
import com.social.meli.exception.NotFoundException;
import com.social.meli.exception.UserIsNotVendorException;
import com.social.meli.repository.IPostRepository;
import com.social.meli.repository.IProductRepository;
import com.social.meli.repository.IUserRepository;
import com.social.meli.dto.request.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.social.meli.entity.UserType.VENDOR;
import static java.lang.Boolean.TRUE;
import static org.apache.commons.lang3.StringUtils.isBlank;


@Service
@AllArgsConstructor
public class PostService implements IPostService {
    public static final String NO_SE_ENCONTRO_AL_USUARIO = "No se encontro al usuario";
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    @Override
    public PublicationDto obtainLastPublicationsByTheFollowedVendors(Integer userId, String order) {
        List<Integer> followedVendors = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new NotFoundException(NO_SE_ENCONTRO_AL_USUARIO))
                .getFollowedId();

        List<Post> latestPost = new ArrayList<>();
        for (Integer vendorId : followedVendors) {
            Optional<List<Post>> filteredPostOfOneUser = postRepository.getPostFromTheLastTwoWeeksByUserId(vendorId);
            filteredPostOfOneUser.ifPresent(latestPost::addAll);
        }
        List<PostDto> sortedPost = addRecoverProductsOnPosts(latestPost);
        return new PublicationDto(userId, sortPostsByDate(sortedPost, order));
    }

    public List<PostDto> addRecoverProductsOnPosts(List<Post> postList) {
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : postList) {
            postDtoList.add(post.toDto(productRepository.getProductById(post.getProductId()).orElseThrow(() -> new NotFoundException("No se encontro el producto"))));
        }
        return postDtoList;
    }

    @Override
    public void addPost(PostDTO postDto) {
        validatePost(postDto);
        Post finalPost = new Post(idCounter.incrementAndGet(), postDto);
        postRepository.add(finalPost);
    }

    @Override
    public void addPromoPost(PromoPostDto promoPostDto) {
        validatePromoPost(promoPostDto);
        if (productRepository.getProductById(promoPostDto.getProduct().getId()).isEmpty())
            productRepository.add(promoPostDto.getProduct());
        postRepository.add(new PromoPost(idCounter.incrementAndGet(), promoPostDto));
    }
    @Override
    public VendorPromoProductCountDto getVendorPromoProductCount(Integer userId) {
        User user = validateAndGetUser(userId);
        return new VendorPromoProductCountDto(userId, user.getName(), postRepository.findPromoPostsByUserId(userId).size());
    }

    @Override
    public VendorPromoProductListDto getVendorPromoProductList(Integer userId) {
        User user = validateAndGetUser(userId);
        List<PromoPost> promoPostList = postRepository.findPromoPostsByUserId(userId);
        List<PromoPostResponseDto> promoPostResponseDtoList = new ArrayList<>();
        for (PromoPost promoPost : promoPostList) {
            Product product = productRepository.getProductById(promoPost.getProductId()).orElseThrow(() -> new NotFoundException("No se encontro al producto con el id: " + promoPost.getProductId()));
            promoPostResponseDtoList.add(new PromoPostResponseDto(promoPost, product));
        }
        return new VendorPromoProductListDto(userId, user.getName(), promoPostResponseDtoList);
    }


    private void validatePromoPost(PromoPostDto promoPostDto) {
        validatePost(promoPostDto);
        validateNumberValue(promoPostDto.getDiscount(), "Descuento");
        if (!TRUE.equals(promoPostDto.isHasPromo()))
            throw new InvalidDataException("Error al enviar los datos: hasPromo tiene que ser verdadero");
    }

    private void validatePost(PostDTO post) {
        validateNumberValue(post.getUserId(), "Usuario");
        validateNumberValue(post.getCategory(), "Categoria");
        validateNumberValue(post.getPrice(), "Precio");
        validateProduct(post.getProduct());
        if (post.getDate() == null) {
            post.setDate(LocalDate.now());
        }
        userRepository.findUserByUserId(post.getUserId()).orElseThrow(() -> new NotFoundException(NO_SE_ENCONTRO_AL_USUARIO));

    }

    public List<PostDto> sortPostsByDate(List<PostDto> posts, String order) {
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


    private void validateNumberValue(Number number, String variableName) {
        if (number.doubleValue() <= 0) {
            throw new InvalidDataException("Error al enviar los datos: " + variableName + " no válido");
        }
    }

    private void validateProduct(Product product) {
        if (product == null || product.getId() <= 0 || isBlank(product.getName()))
            throw new InvalidDataException("Error al enviar los datos: Producto no válido");
    }

    private User validateAndGetUser(Integer userId) {
        User user = userRepository.findUserByUserId(userId).orElseThrow(() -> new NotFoundException(NO_SE_ENCONTRO_AL_USUARIO));
        if (!VENDOR.equals(user.getType())) throw new UserIsNotVendorException("El usuario no es un vendedor");
        return user;
    }
}
