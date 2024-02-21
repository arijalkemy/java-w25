package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PostsByUserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostsCountDTO;

public interface IPostService {
    public void addPost(com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO postDTO);
    public LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order);
    public void addPostWithPromotion(PostDTO postDTO);
    public PromoPostsCountDTO getAmountPromoPost(int userId);
    public PostsByUserDTO getPromoPostsByUser(int userId, String order);
}
