package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostCountResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoListResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;

public interface IPostService {

    PostResponseDTO createPost(PostRequestDTO request);
    
    PostListDTO getLastPostsByFollowed(Integer userId, String order);
    PostCountResponseDTO getPromoCountById(Integer userId);
    PostPromoListResponseDTO getPromoListById(Integer userId);
}
