package com.grupo08.socialmeli.service;

import java.util.List;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.response.PostPostPromoCountDto;

public interface IPostService {
    public ExceptionDto insertPost(PostDto postDto);
    public List<PostDto> getAll();
    void findExceptionsPostDto(PostDto postDto);
    public PostPostPromoCountDto getPostPromoCount(Long userId);
;}
