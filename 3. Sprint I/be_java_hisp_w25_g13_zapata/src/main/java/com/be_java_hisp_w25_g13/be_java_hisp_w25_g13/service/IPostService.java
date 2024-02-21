package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoResponseDTO;

import java.util.List;

public interface IPostService {
    PostDTO addPost(PostDTO postDTO);
    List<PostDTO> getPosts(Integer idUsuario);
    PromoDTO addPromotionPost(PromoDTO promoDTO);

    PromoResponseDTO getPromos(Integer userId);
}
