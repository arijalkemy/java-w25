package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.request.PostDTO;

import java.util.List;

public interface ISellerService {
    public void addPost(PostDTO postDTO);
    List<PostDTO> findAllPosts();
    public Boolean quitFollower(String sellerId, String userId);
}
