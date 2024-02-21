package com.grupo08.socialmeli.service;

import java.util.List;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.PromoPostDto;
import com.grupo08.socialmeli.dto.response.ProductPromoCountDto;

public interface IPostService {
    public ExceptionDto insertPost(PostDto postDto);
    ExceptionDto insertPromoPost(PromoPostDto promoPostDto);
    ProductPromoCountDto countPromoPost(int sellerId);
    public List<PostDto> getAll();
    void findExceptionsPostDto(PostDto postDto);
;}
