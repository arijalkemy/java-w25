package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.dto.request.PostPromoDto;
import com.grupo08.socialmeli.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostPromoRepo {
    void insertPost(PostPromoDto postPromoDto);
    List<PostPromoDto> getAll();
    Optional<PostPromoDto> getPostByProductId(int productId);
    List<PostPromoDto> getByIdUser(int idUser);
}
