package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.SavePromoDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PromoCountDTO;


public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);

    FollowingPostDTO getPostsOrderedByDate(Integer userId, String order);

    GenericResponseDTO savePromoPost(SavePromoDTO post);

    PromoCountDTO getPromoCount(Integer userId);

    GenericResponseDTO endPromo(Integer postId);
}
