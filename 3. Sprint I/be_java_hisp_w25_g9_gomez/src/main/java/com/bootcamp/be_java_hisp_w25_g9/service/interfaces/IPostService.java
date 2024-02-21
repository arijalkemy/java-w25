package com.bootcamp.be_java_hisp_w25_g9.service.interfaces;

import com.bootcamp.be_java_hisp_w25_g9.dto.PromoPostDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.*;

import java.util.List;

public interface IPostService {
    MessageDto createPost(PostRequestDto postRequestDto);
    MessageDto createPromoPost (PromoPostRequestDto promoPostRequestDto);
    FollowedPostsDto getPost(int userId);
    FollowedPostsDto getPost(int userId, String order);
    PromoProductsCountDto getPromoProductsCountBySeller(int userId);
    PromoPostResponseDto getPromoPostBySeller(int userId);
    List<PromoPostDto> getPostByType(String type, boolean promo);
    List<PostResponseDto> getPostByType(String type);


}
