package com.example.be_java_hisp_w25_g01_manzano.service;

import com.example.be_java_hisp_w25_g01_manzano.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.request.PromoPostDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PromoPostsListDTO;

public interface IPostService {
    PostsListDTO getLastPostsFollowedBy(Integer userId);
    PromoPostsListDTO getSalePostsFollowedBy(Integer userId, String order);
    MessagesDTO createPost(PostDTO post);
    MessagesDTO createPromoPost(PromoPostDTO post);
    PromoPostCountDTO getPromoPostCount(Integer id);


}
