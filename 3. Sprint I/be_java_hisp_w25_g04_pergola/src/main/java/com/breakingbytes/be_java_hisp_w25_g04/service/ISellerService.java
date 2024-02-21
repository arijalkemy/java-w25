package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoCountsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;

import java.util.List;

public interface ISellerService {
    void addPost(RequestPostDTO requestPostDTO);
    List<RequestPostDTO> findAllPosts();
    Boolean quitFollower(String sellerId, String userId);
    PromoCountsDTO getCountPromoProds(String userId);
    List<PromoPostsDTO> getPromoPost(int userId);
    LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order);
    FollowersCountDTO getCountFollowersOfSeller(int id);
}
