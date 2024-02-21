package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.CountPromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ListPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ListPromoPostsDTO;

import java.util.List;

public interface ISellerService {
    void addPost(RequestPostDTO requestPostDTO);
    void addPromoPost(RequestPromoPostDTO requestPromoPostDTO);
    public CountPromoPostDTO countPromoPosts(int sellerId);
    List<RequestPostDTO> findAllPosts();
    Boolean quitFollower(String sellerId, String userId);
    ListPostsDTO getPostOfVendorsFollowedByUser(int id, String order);
    ListPromoPostsDTO listPromoPosts(int id, String order);
    FollowersCountDTO getCountFollowersOfSeller(int id);
}
