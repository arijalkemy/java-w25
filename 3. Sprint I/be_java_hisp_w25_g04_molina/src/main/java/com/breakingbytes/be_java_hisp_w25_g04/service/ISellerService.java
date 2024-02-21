package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoProductsCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoProductsListDTO;

import java.util.List;

public interface ISellerService {
    void addPost(RequestPostDTO requestPostDTO);
    List<RequestPostDTO> findAllPosts();
    Boolean quitFollower(String sellerId, String userId);
    LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order);
    FollowersCountDTO getCountFollowersOfSeller(int id);
    PromoProductsCountDTO getCountPromoProductsOfSeller(int userId);
    PromoProductsListDTO getPromoProductsList(int userId);
}
