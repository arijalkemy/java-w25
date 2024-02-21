package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.NumberPromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostPromosDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostResponseDTO;

import java.util.List;

public interface IPostService {
    PostResponseDTO addPost(PostDTO postDTO);
    List<PostDTO> getPosts(Integer idUsuario);
    PostResponseDTO addPromoPost(PostDTO postDTO);
    NumberPromoPostDTO getCountPromoProducts(Integer idUsuario);
    PostPromosDTO getPromoPosts(Integer idUsuario);
}
