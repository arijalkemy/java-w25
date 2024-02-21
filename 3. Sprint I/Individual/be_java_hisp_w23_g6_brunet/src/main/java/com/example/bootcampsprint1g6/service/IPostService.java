package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.repository.PostRepositoryImpl;

import java.util.List;

public interface IPostService {

    PostResponseDTO createPost(PostRequestDTO request);
    
    PostListDTO getLastPostsByFollowed(Integer userId, String order);

    PostResponseDTO createPromoPost(PostRequestDTO request);

    GenericResponseDTO getCountPromoPost(Integer userId);

    List<PostResponseDTO> getListPromoPostByUserId(Integer userId);

}
