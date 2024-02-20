package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.response.*;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePromoPostRequestDTO;

public interface ISellerPostService {
    SellerPostDTO createPost(CreatePostRequestDTO request);
    SellerPromoPostDTO createPromoPost(CreatePromoPostRequestDTO request);
    SellerPostsListDTO getFollowedSellersLatestPosts(Integer userId, String order);
    PromoPostCountDTO getPromoPostCount(Integer userId);
    SellerPromoPostsListDTO getPromoPostList(Integer userId);
    //SellerPostsListDTO getFollowedSellersLatestPostsOrdered(OrganizerByDateDTO organizer);

}
