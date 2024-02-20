package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;

import java.util.List;

public interface IPostService {
    PostDTO addPost(PostDTO postDTO);
    List<PostDTO> getPosts(Integer idUsuario);

}
