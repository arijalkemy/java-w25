package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;

import java.util.List;

public interface IPostService {
    PostDTO addPost(PostDTO postDTO);
    PostPromDTO addPostProm(PostPromDTO postPromDTO);
    SellerPostDTO getPostPerSeller(Integer id, String orderBy);
    PostPromCountDTO cantPostPromSeller(Integer id);
    PostPromListDTO listProdPromSeller(Integer id);
    List<PostDTO> getPosts(Integer idUsuario);


}
