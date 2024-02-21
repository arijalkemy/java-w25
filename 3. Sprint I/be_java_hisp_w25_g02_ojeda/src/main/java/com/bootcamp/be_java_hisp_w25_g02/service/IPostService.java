package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.EndPromotionDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.*;


public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);

    FollowingPostDTO searchPostsOrderedByDate(Integer userId, String order);

    PromotionListDTO getPromotionsList(Integer userId);

    PromotionPostDTO createNewPromo(PromotionPostDTO promoDTO);

    PromotionAmountDTO getPromotionsAmount(Integer userId);

    PromotionPostDTO endPromotion(EndPromotionDTO promoId);
}
