package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PromoPostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;

import java.util.List;

public interface IPostService {

    PostResponseDTO createPost(PostRequestDTO request);
    PostResponseDTO createPromoPost(PromoPostRequestDTO request);

    List<PostResponseDTO> getPromoPost(Integer userId);
    GenericResponseDTO getAumountPromoPost(Integer userId);
    PostListDTO getLastPostsByFollowed(Integer userId, String order);

}
