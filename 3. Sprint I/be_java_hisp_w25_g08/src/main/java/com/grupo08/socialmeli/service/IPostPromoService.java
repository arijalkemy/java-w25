package com.grupo08.socialmeli.service;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.request.PostPromoDto;
import com.grupo08.socialmeli.dto.response.PromosDto;

import java.util.List;

public interface IPostPromoService {
    public List<PostPromoDto> getAll();

    public ExceptionDto insertPostPromo(PostPromoDto postPromoDto);
    public PromosDto getPromosBySeller(int userId);
    void findExceptionsPostPromoDto(PostPromoDto postPromoDto);
}
