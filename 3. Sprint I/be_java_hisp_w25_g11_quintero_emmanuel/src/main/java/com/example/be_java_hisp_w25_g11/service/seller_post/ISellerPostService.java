package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.SellerPromoPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePromoPostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.OrganizerByDateDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPostsListDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPromoPostCountDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPromoPostListDTO;

public interface ISellerPostService {
    SellerPostDTO createPost(CreatePostRequestDTO request);
    SellerPromoPostDTO createPromoPost(CreatePromoPostRequestDTO request);
    SellerPostsListDTO getFollowedSellersLatestPosts(Integer userId, String order);
    SellerPromoPostCountDTO getSellerPromoPostCount(Integer userId);
    SellerPromoPostListDTO getSellerPromoPostList(Integer userId);

}
