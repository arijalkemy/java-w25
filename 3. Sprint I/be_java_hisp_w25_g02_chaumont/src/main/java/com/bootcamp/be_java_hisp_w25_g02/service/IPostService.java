package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.*;


public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);

    FollowingPostDTO getPostsOrderedByDate(Integer userId, String order);

    GenericResponseDTO newPromoPost(PostDTO promoPost);

    PromoPostCountDTO getPromoCountByUser(Integer userId);

    PostListByCategoryDTO searchPostByCategory(Integer category);
}
