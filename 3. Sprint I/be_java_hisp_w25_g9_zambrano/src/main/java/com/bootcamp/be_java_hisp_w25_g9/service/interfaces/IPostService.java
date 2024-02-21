package com.bootcamp.be_java_hisp_w25_g9.service.interfaces;

import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.*;

public interface IPostService {
    MessageDto createPost(PostRequestDto postRequestDto);
    FollowedPostsDto getPost(int userId);
    FollowedPostsDto getPost(int userId, String order);
    MessageDto createPromoPost(PostRequestDto postRequestDto);
    PromoProductsCountDto getPromoPostCount(int userId);
    PromoProductsListDto getPromoPostList(int userId);
}
