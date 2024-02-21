package com.grupo08.socialmeli.service;

import java.util.List;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.response.PromoPostCountDTO;
import com.grupo08.socialmeli.dto.response.PromoPostListDTO;

public interface IPostService {
    public ExceptionDto insertPost(PostDto postDto);
    public List<PostDto> getAll();
    void findExceptionsPostDto(PostDto postDto);

    PromoPostCountDTO getQuantityPromoPostBySeller(int userId);

    PromoPostListDTO getPromoPostsBySeller(int userId);
;}
