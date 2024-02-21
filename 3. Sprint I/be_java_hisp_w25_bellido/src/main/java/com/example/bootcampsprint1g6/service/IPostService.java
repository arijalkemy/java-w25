package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.PostPromoListDTO;
import com.example.bootcampsprint1g6.dto.PromoCountDTO;
import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;

import java.util.List;

public interface IPostService {

    PostResponseDTO createPost(PostRequestDTO request);
    
    PostListDTO getLastPostsByFollowed(Integer userId, String order);

    PostPromoResponseDTO createPostPromo(PostPromoRequestDTO request);

    PromoCountDTO countPromosById(Integer userId);

    PostPromoListDTO listPromosByUserId(Integer userId);
}
