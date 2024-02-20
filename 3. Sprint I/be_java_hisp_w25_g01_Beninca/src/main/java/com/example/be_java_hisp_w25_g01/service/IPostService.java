package com.example.be_java_hisp_w25_g01.service;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.PromoPostDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsByPriceDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PromoProductsCountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPostService {


    PostsListDTO getLastPostsFollowedBy(Integer userId);

    MessagesDTO followUser (int userId);

    MessagesDTO createPost(PostDTO post);
    MessagesDTO createPromoPost (PromoPostDTO promoPostDto);
    PromoProductsCountDTO getPromoProductsCount (Integer userId);


    //US 0012 - Buscar posts por categoría y rango de precios.
    List<PostsByPriceDTO> searchPosts(Integer category, Double minPrice, Double maxPrice);
}
