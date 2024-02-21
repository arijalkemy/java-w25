package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;

import java.util.List;

public interface IPostService {

    MessageDto savePost(PostDto postDto);
    List<PostDto> getAllPosts();
    UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted);
    MessageDto savePromoPost(PromoPostDto promoPostPayloadDto);
    UserPromoPostCountDto getQtyUserPromoPost(Integer userId);
    List<Post> getPromoPostList (Integer userId);


}
