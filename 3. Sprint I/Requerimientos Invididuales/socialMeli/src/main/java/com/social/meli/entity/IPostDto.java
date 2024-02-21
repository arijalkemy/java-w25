package com.social.meli.entity;

import com.social.meli.dto.response.PostDto;

public interface IPostDto {
    PostDto toDto(Product product);
}
