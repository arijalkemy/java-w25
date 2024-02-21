package com.bootcamp.be_java_hisp_w25_g9.service.interfaces;

import java.util.List;
import com.bootcamp.be_java_hisp_w25_g9.dto.SellerPromoPostCountDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PostResponseDto;

public interface IPostService {
    MessageDto createPost(PostRequestDto postRequestDto);
    FollowedPostsDto getPost(int userId);
    FollowedPostsDto getPost(int userId, String order);
    MessageDto createPromoPost(PostRequestDto newPost);
    SellerPromoPostCountDto getPromoPostCount(int userId);
    UserDto getUserById(int userId);
    List<PostResponseDto> getSellerPromoPosts(int userId);
}
