package org.bootcamp.javazoo.service.interfaces;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;

import java.util.List;

public interface IPostService {
    PostsFollowedUserDto getPostsBySellerOfUser(int userId, String order);

    MessageDto addNewPost(PostDto postDto);
}
