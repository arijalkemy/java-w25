package com.grupo08.socialmeli.service;

import java.util.List;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;

public interface IPostService {
    public ExceptionDto insertPost(PostDto postDto);
    public List<PostDto> getAll();
    void findExceptionsPostDto(PostDto postDto);
;}
