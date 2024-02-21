package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostNumberDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;

import java.util.List;

public interface IPostService {
    PostDTO addPost(PostDTO postDTO);
    PromoPostDTO addPromoPost(PromoPostDTO postDTO);
    List<PostDTO> getPosts(Integer userId);
    SellerPostDTO getPostPerSeller(Integer id, String order);
    PromoPostNumberDTO getPromoPostPerSeller(Integer sellerId);

}
