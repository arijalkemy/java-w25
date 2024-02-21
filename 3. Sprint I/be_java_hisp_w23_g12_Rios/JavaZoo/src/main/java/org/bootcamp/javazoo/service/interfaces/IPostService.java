package org.bootcamp.javazoo.service.interfaces;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.dto.response.PromoPostCountDto;
import org.bootcamp.javazoo.dto.response.PromoPostDto;

import java.util.List;

public interface IPostService {
    List<PostResponseDto> getPostsBySeller(int userId, String order);

    PostsFollowedUserDto getPostsBySellerOfUser(int userId, String order);

    MessageDto addNewPost(PostDto postDto);

    PromoPostCountDto getPromoPostCount(Integer userId);

    PromoPostDto getPromoPostListById(Integer userId, String order);
}
