package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.*;

import java.util.List;


public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);

    FollowingPostDTO getPostsOrderedByDate(Integer userId, String order, Boolean filterByPromotion);
    GenericResponseDTO savePromoPost(PromoPostDTO promoPostDTO);
    PromoPostCountDTO getPromoPostCount(Integer userId);
    GenericResponseDTO updatePromotionDiscount(Integer post_id, double discount);
    GenericResponseDTO updateEndPromotion(Integer post_id);
    List<PromotionPostDTO> getPostOfToday(String order);
}
