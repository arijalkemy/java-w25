package com.be_java_hisp_w25_g02_zanaboni.service;

import com.be_java_hisp_w25_g02_zanaboni.dto.response.*;

public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);
    FollowingPostDTO searchPostsOrderedByDate(Integer userId, String order);
    SalePostDTO countPostsOnSaleById(Integer userId);
    SalePostListDTO getAllPostsOnSaleById(Integer userId);
}