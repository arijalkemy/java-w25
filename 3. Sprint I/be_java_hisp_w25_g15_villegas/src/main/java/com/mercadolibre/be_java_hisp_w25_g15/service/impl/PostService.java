package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountPromoProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PromoListDto;
import com.mercadolibre.be_java_hisp_w25_g15.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import com.mercadolibre.be_java_hisp_w25_g15.model.Product;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IPostRepository;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IProductRepository;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w25_g15.service.IPostService;
import com.mercadolibre.be_java_hisp_w25_g15.utils.ObjectMapperBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private final ObjectMapperBean mapper;

    @Override
    public PostListDto createPost(PostDto postDto) {
        Optional<User> user = userRepository.getUserById(postDto.user_id());
        if (user.isEmpty())
            throw new NotFoundException("User not found");
        if (!(user.get() instanceof Seller))
            throw new ConflictException("User must be a seller to create a post");

        //Creamos el producto
        Product newProduct = this.productRepository.save(mapper.getMapper().convertValue(postDto.product(), Product.class));

        Post post = Post.builder()
                .user(user.get())
                .date(LocalDate.parse(postDto.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .product(newProduct)
                .category(postDto.category())
                .price(postDto.price())
                .has_promo(postDto.has_promo())
                .discount(postDto.discount())
                .build();

        Post newPost = this.postRepository.addPost(post);
        return this.mapper.postToPostListDto(newPost);
    }


    @Override
    public PostGetListDto getPostsBySellerIdLastTwoWeeks(int userId, DateOrderEnumDto dateOrder) {
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " + userId + "not found."));
        if (user.getFollowed() == null || user.getFollowed().isEmpty()) {
            throw new NotFoundException("The user with id " + userId + " has no followed users");
        }
        List<PostListDto> postDtoList = new ArrayList<>();
        user.getFollowed().forEach(followedUser -> postDtoList.addAll(
                        this.postRepository.findAllPostsBySellerIdBetweenDateRange(
                                followedUser.getId(), LocalDate.now().minusWeeks(2), LocalDate.now()
                        ).stream().map(this.mapper::postToPostListDto).toList()
                )
        );
        if (postDtoList.isEmpty()) {
            throw new NotFoundException("The users followed by the user with id " + userId + " haven´t posted in the last two weeks.");
        }
        sortPostDtoListByDate(dateOrder, postDtoList);
        return new PostGetListDto(
                userId,
                postDtoList
        );
    }

    @Override
    public CountPromoProductDto countPromoProductsByUserId(int userId) {
        Optional<User> user = this.userRepository.getUserById(userId);
        if (user.isEmpty())
            throw new NotFoundException("User not found");
        if (!(user.get() instanceof Seller))
            throw new ConflictException("User is not a Seller");
        List<Post> postWithPromoByUser = this.postRepository.findByUserIdAndWithPromo(userId);
        return new CountPromoProductDto(
                user.get().getId(),
                user.get().getUsername(),
                postWithPromoByUser.size()
        );
    }

    @Override
    public PromoListDto getPostPromoListByUserId(int userId) {
        Optional<User> user = this.userRepository.getUserById(userId);
        if (user.isEmpty())
            throw new NotFoundException("User not found");
        if (!(user.get() instanceof Seller))
            throw new ConflictException("User is not a Seller");
        List<Post> postWithPromoByUser = this.postRepository.findByUserIdAndWithPromo(userId);
        return new PromoListDto(
                user.get().getId(),
                user.get().getUsername(),
                postWithPromoByUser.stream().map(this.mapper::postToPostListDto).toList()
        );
    }

    private static void sortPostDtoListByDate(DateOrderEnumDto dateOrder, List<PostListDto> postDtoList) {
        if (dateOrder == null) return;
        Comparator<String> order = Comparator.reverseOrder();
        if (dateOrder == DateOrderEnumDto.DATE_ASC) {
            order = Comparator.naturalOrder();
        }
        postDtoList.sort(Comparator.comparing(PostListDto::date));
    }
}