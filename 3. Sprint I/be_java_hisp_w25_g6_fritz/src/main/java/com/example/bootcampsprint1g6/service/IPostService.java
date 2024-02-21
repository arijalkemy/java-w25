package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.PostPromoCountDTO;
import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.FullPostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO request);
    PostListDTO getLastPostsByFollowed(Integer userId, String order);
    PostPromoResponseDTO createPostPromo(PostPromoRequestDTO request);
    PostPromoCountDTO getPostPromoCount(Integer userId);
    FullPostPromoResponseDTO getPostPromoList(Integer userId);
}
