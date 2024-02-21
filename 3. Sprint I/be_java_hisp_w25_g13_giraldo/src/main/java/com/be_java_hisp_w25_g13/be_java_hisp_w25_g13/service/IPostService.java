package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;

import java.util.List;

public interface IPostService {
    PostResponseDTO addPost(PostDTO postDTO);
    List<PostDTO> getPosts(Integer idUsuario);

    PostResponseDTO addPromoPost(PostDTO promoPostDTO);

    PromoPostNumberDTO getCountSellerPromoPost(Integer userId);

    PromoPostSellerDTO getSellerPromoPost(Integer userId, String order);

    SellerPostDTO getPostPerSeller(Integer id, String orderBy);

}
