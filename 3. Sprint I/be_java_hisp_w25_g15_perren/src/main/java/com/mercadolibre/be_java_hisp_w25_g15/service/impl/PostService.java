package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetPromoListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PromoPostCountDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
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
import java.util.*;
import java.util.stream.Collectors;

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
    public PostGetListDto getPostsBySellerIdLastTwoWeeks(int userId, DateOrderEnumDto dateOrder) {
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

    //Count promo posts from a given user
    @Override
    public PromoPostCountDto countPromoPost(int userId) {
        User user = userRepository.getUserById(userId).orElseThrow(() -> new NotFoundException("User with id " +userId+ "not found."));
        int promoPostCount = this.postRepository.countPromoPostsBySellerId(userId);
        return new PromoPostCountDto(userId, user.getUsername(), promoPostCount);
    }


    //List all promo posts from a given user
    @Override
    public PostGetPromoListDto getPromoPostListByUser(int userId, String order) {
        // check if user exists
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " +userId+ " not found."));
        // check if user is a seller
        if(!(user instanceof Seller)){
            throw new ConflictException("User provided must be a seller");
        }
        List<PostDto> postDtoList =  this.postRepository.findPromoPostsBySellerId(userId).stream().map(p -> mapper.getMapper().convertValue(p, PostDto.class)).toList();
        postDtoList = sortPostDtoListByName(postDtoList, order);

        return new PostGetPromoListDto(
                userId,
                user.getUsername(),
                postDtoList
        );
    }

    //Sort post list by date
    private static void sortPostDtoListByDate(DateOrderEnumDto dateOrder, List<PostDto> postDtoList) {
        if(dateOrder == null) return;
        Comparator<String> order = Comparator.reverseOrder();
        if(dateOrder == DateOrderEnumDto.DATE_ASC) {
            order = Comparator.naturalOrder();
        }
        postDtoList.sort(Comparator.comparing(PostDto::date, order));
    }


    //Sort post list by name
    private List<PostDto> sortPostDtoListByName(List<PostDto> postListDtos, String order) {
        //create a mutable copy of the list
        List<PostDto> mutablePostListDtos = new ArrayList<>(postListDtos);
        //check if order is not null and if the list has more than one element
        if (order != null && mutablePostListDtos.size() > 1) {
            if (order.equals("name_asc")) {
                // Ascending order by product name
                mutablePostListDtos.sort(Comparator.comparing(postDto -> postDto.product().product_name()));
            } else if (order.equals("name_desc")) {
                // Descending order by product name
                mutablePostListDtos.sort(Comparator.comparing(postDto -> postDto.product().product_name(), Comparator.reverseOrder()));
            }
        }
        return mutablePostListDtos;
    }


}
