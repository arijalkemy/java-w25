package com.grupo08.socialmeli.service;

import java.util.List;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.PostPromoDto;
import com.grupo08.socialmeli.dto.response.PromoPostxSellerDto;

public interface IPostService {
    public ExceptionDto insertPost(PostDto postDto);
    public List<PostDto> getAll();
    public List<PostPromoDto> getAllPromos();
    void findExceptionsPostDto(PostDto postDto);
    public ExceptionDto insertPostPromo(PostPromoDto postPromoDto);
    public PromoPostxSellerDto getPromoPostxSeller(int user_id);

;}
