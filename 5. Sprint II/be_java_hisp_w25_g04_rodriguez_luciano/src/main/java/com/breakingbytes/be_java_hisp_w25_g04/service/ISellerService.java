package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;

import java.util.List;

public interface ISellerService {
    void addPost(RequestPostDTO requestPostDTO);
    List<RequestPostDTO> findAllPosts();
    Boolean quitFollower(Integer sellerId, Integer userId);
    LastPostsDTO getPostOfVendorsFollowedByUser(Integer id, String order);
    FollowersCountDTO getCountFollowersOfSeller(Integer id);
}
