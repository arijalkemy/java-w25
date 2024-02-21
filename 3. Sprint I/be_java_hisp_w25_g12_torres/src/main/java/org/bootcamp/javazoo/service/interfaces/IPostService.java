package org.bootcamp.javazoo.service.interfaces;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostPromoDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.response.CountPromoDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.dto.response.PostPromoListDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.entity.Post;

import java.util.List;

public interface IPostService {
    List<PostResponseDto> getPostsBySeller(int userId, String order);

    PostsFollowedUserDto getPostsBySellerOfUser(int userId, String order);

    MessageDto addNewPost(PostDto postDto);

    MessageDto addNewPostPromo(PostPromoDto postPromoDto);

    CountPromoDto getCountPromoPost(Integer userId);

    List<Post> getPostsBySellerId(Integer sellerId);

    PostPromoListDto getPromoPostsBySeller(Integer sellerId, String order);
}
