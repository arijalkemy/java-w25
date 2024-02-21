package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.*;
import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;

import java.util.List;


public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);
    FollowingPostDTO getPostsOrderedByDate(Integer userId, String order);
//    GenericResponseDTO savePostWithDiscount(PostWithDiscountDTO postWithDiscountDTO);
    GenericResponseDTO savePostWithDiscount(PostDTO postDTO);
    PromoPostsCountDTO getPromoPostsCount(Integer userId);
    SellerPromoPostsDTO getPromoPosts(Integer userId);
    GenericResponseDTO deletePost(Integer postId);
    List<PostRespDTO> getAllPosts();
    GenericResponseDTO updatePost(Integer id, PostDTO postDTO);
}
