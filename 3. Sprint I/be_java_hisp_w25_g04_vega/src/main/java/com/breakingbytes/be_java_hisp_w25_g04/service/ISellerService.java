package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostDTO;

import java.util.List;

public interface ISellerService {
    void addPost(RequestPostDTO requestPostDTO);
    List<RequestPostDTO> findAllPosts();
    Boolean quitFollower(String sellerId, String userId);
    LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order);
    FollowersCountDTO getCountFollowersOfSeller(int id);
    PromoPostCountDTO countProducsInDiscount(int sellerId);
    PromoPostDTO findPostsWithDiscountByIdSeller(int sellerId);

    List<PromoPostDTO> findPostWithDiscountOf(int discount);
}
