package com.example.be_java_hisp_w25_g11_grisales.service.seller_post;

import com.example.be_java_hisp_w25_g11_grisales.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.SellerPromoPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.request.CreatePromoPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.response.SellerPostsListDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.response.SellerPromoCountDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.response.SellerPromoPostListDTO;

public interface ISellerPostService {
    SellerPostDTO createPost(CreatePostRequestDTO request);
    SellerPostsListDTO getFollowedSellersLatestPosts(Integer userId, String order);
    //SellerPostsListDTO getFollowedSellersLatestPostsOrdered(OrganizerByDateDTO organizer);
    SellerPromoPostDTO createNewPromoProduct(CreatePromoPostDTO promoRequest);
    SellerPromoCountDTO countPromoProducts(Integer userId);
    SellerPromoPostListDTO getSellerPromoProductList(Integer userId);
}
