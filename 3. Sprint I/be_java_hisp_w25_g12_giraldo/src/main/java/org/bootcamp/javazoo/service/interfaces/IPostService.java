package org.bootcamp.javazoo.service.interfaces;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.request.PostPromoDto;
import org.bootcamp.javazoo.dto.response.CountProductsPromoDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.dto.response.ProductPromoDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;

import java.util.List;

public interface IPostService {
    List<PostResponseDto> getPostsBySeller(int userId, String order);

    PostsFollowedUserDto getPostsBySellerOfUser(int userId, String order);

    MessageDto addNewPost(PostDto postDto);

    public MessageDto addNewPostPromo(PostPromoDto postPromoDto);

    public CountProductsPromoDto countProductsPromoBySeller (int userId);

    public ProductPromoDto listProductsPromoBySeller (int sellerId, String order);
}
