package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.OrganizerByDateDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPostsListDTO;

public interface ISellerPostService {
    SellerPostDTO createPost(CreatePostRequestDTO request);
    SellerPostsListDTO getFollowedSellersLatestPosts(Integer userId, String order);
    //SellerPostsListDTO getFollowedSellersLatestPostsOrdered(OrganizerByDateDTO organizer);

}
