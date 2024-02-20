package com.example.be_java_hisp_w25_g01.service;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.PromoPostDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PromoCountDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PromoNewPriceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPostService {


    PostsListDTO getLastPostsFollowedBy(Integer userId);

    MessagesDTO followUser (int userId);

    MessagesDTO createPost(PostDTO post);

    MessagesDTO createPromoPost(PromoPostDTO post);

    PromoCountDTO getPromoCount(Integer userId);

    List<PromoNewPriceDTO> getPromoNewPrices();


}
