package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PostDto;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostCountDTO;

import java.util.List;

public interface ISellerService {
    void addPost(PostDTO postDTO);
    List<PostDto> findAllPosts();
    public Boolean quitFollower(String sellerId, String userId);

    PromoPostCountDTO countProducsInDiscount(int sellerId);
    PromoPostDTO findPostsWithDiscountByIdSeller(int sellerId);
}
