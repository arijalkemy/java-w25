package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.PromoPostDTO;

import java.util.List;

public interface ISellerService {
    void addPost(PostDTO postDTO);
    List<PostDTO> findAllPosts();
    Boolean quitFollower(String sellerId, String userId);
    LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order);
    FollowersCountDTO getCountFollowersOfSeller(int id);

    PromoPostDTO getPromoPostCount(int userId);

    List<PostDTO> getPromoPosts(int userId);
}
