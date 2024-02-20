package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostWithPromoDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.PriceOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostsWithPromoCountDto;
import com.mercadolibre.be_java_hisp_w25_g15.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IPostRepository;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w25_g15.service.IPostService;
import com.mercadolibre.be_java_hisp_w25_g15.utils.ObjectMapperBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final ObjectMapperBean mapper;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapper.getMapper().convertValue(postDto, Post.class);
        Optional<User> user = userRepository.getUserById(postDto.user_id());
        if (user.isPresent()) {
           // si el usuario es Seller puedo publicar
            if((user.get() instanceof Seller)){
                post.setUserId(user.get().getId());
                Post newPost = postRepository.addPost(post);
                return mapper.getMapper().convertValue(newPost, PostDto.class);
            }else {
                throw new ConflictException("User must be a seller to create a post");
            }
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public PostGetListDto getPostsOfFollowedSellersByUserInLastTwoWeeks(int userId, DateOrderEnumDto dateOrder) {
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " +userId+ " not found."));
        if(user.getFollowed() == null || user.getFollowed().isEmpty()) {
            throw new NotFoundException("The user with id "+userId+" has no followed users");
        }
        List<PostDto> postDtoList =  new ArrayList<>();
        user.getFollowed().forEach(followedUser -> postDtoList.addAll(
                this.postRepository.findAllPostsBySellerIdBetweenDateRange(
                        followedUser.getId(), LocalDate.now().minusWeeks(2), LocalDate.now()
                        ).stream().map(p -> mapper.getMapper().convertValue(p, PostDto.class)).toList()
                )
        );
        if(postDtoList.isEmpty()){
            throw new NotFoundException("The users followed by the user with id " +userId+ " haven´t posted in the last two weeks.");
        }
        sortPostDtoListByDate(dateOrder, postDtoList);
        return new PostGetListDto(
                userId,
                postDtoList
        );
    }

    @Override
    public PostsWithPromoCountDto getQuantityOfPostsWithPromoBySellerId(int sellerId) {
        User seller = userRepository.getUserById(sellerId)
                .orElseThrow(() -> new NotFoundException("Seller with id " +sellerId+ " not found."));
        long promoProductsCount = postRepository.findAllPostsBySellerId(sellerId).stream().filter(Post::isHasPromo).count();
        return new PostsWithPromoCountDto(seller.getId(), seller.getUsername(), promoProductsCount);
    }

    @Override
    public PostWithPromoDto createPostWithPromo(PostWithPromoDto postWithPromoDto) {
        Post postWithPromo = mapper.getMapper().convertValue(postWithPromoDto, Post.class);
        User user = userRepository.getUserById(postWithPromoDto.user_id()).orElseThrow(() -> new NotFoundException("User not found"));
        if(!(user instanceof Seller)){
            throw new ConflictException("User must be a seller to create a post");
        }
        return mapper.getMapper().convertValue(postRepository.addPost(postWithPromo), PostWithPromoDto.class);
    }

    @Override
    public List<PostDto> getPostsBetweenPriceRange(double startPrice, double endPrice, PriceOrderEnumDto priceOrder) {
        if(endPrice<startPrice){
            throw new IllegalArgumentException("The start price must be greater than the end price");
        }
        List<Post> postFound = postRepository.findAllPostsBetweenPriceRange(startPrice, endPrice);
        if(postFound.isEmpty()){
            throw new NotFoundException("There are no posts between the price range.");
        }
        List<PostDto> postDtoList = new ArrayList<>(postFound.stream().map(post -> mapper.getMapper().convertValue(post, PostDto.class)).toList());
        sortPostDtoListByPrice(priceOrder, postDtoList);
        return postDtoList;
    }
    private static void sortPostDtoListByPrice(PriceOrderEnumDto priceOrder, List<PostDto> postDtoList) {
        if(priceOrder == null) return;
        Comparator<Double> order = Comparator.reverseOrder();
        if(priceOrder == PriceOrderEnumDto.PRICE_ASC){
            order = Comparator.naturalOrder();
        }
        postDtoList.sort(Comparator.comparing(PostDto::price, order));
    }

    private static void sortPostDtoListByDate(DateOrderEnumDto dateOrder, List<PostDto> postDtoList) {
        if(dateOrder == null) return;
        Comparator<String> order = Comparator.reverseOrder();
        if(dateOrder == DateOrderEnumDto.DATE_ASC) {
            order = Comparator.naturalOrder();
        }
        postDtoList.sort(Comparator.comparing(PostDto::date, order));
    }
}