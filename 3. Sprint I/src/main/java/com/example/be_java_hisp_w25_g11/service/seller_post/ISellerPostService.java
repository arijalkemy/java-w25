package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.product.ProductoPromoQuantityDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestWithPromoDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostListWithDiscountDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostsListDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostWithDiscountDTO;

import java.util.List;

public interface ISellerPostService {
    SellerPostDTO createPost(CreatePostRequestDTO request);
    SellerPostWithDiscountDTO createPostWithPromo(CreatePostRequestWithPromoDTO request);
    SellerPostListWithDiscountDTO getAllPromoProducts(Integer userId);
    ProductoPromoQuantityDTO getQuantityOfProductsWithPromo(Integer request);
    SellerPostsListDTO getFollowedSellersLatestPosts(Integer userId, String order);

}
