package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;

import java.util.List;

public interface IPostService {

    MessageDto savePost(PostDto postDto, boolean isPromo);
    List<PostDto> getAllPosts();
    UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted);
    PromoProductsAmountDto getAmountOfPromoProductsById(Integer id);
    LargestPostDiscountDto getLargestPostDiscount();
    PostsBetweenPriceRangeDto getPostsInRange(String from, String to);

}
