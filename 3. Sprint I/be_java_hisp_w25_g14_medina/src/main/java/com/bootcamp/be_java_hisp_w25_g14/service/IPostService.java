package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;

import java.util.List;

public interface IPostService {

    MessageDto savePost(PostDto postDto);
    MessageDto savePromoPost(PromoPostDto postDto);
    List<PostDto> getAllPosts();
    UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted);

    CountPromoPostDto getPromoProductsCount(Integer userId);
    ListPromoPostDto getPromoProductsList(Integer userId);

    BestPromoDto getBestPromo(Integer userId);

}
