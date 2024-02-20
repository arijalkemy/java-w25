package com.be_java_hisp_w25_g02_zanaboni.service;

import com.be_java_hisp_w25_g02_zanaboni.dto.response.FollowingPostDTO;
import com.be_java_hisp_w25_g02_zanaboni.dto.response.GenericResponseDTO;
import com.be_java_hisp_w25_g02_zanaboni.dto.response.PostDTO;

public interface IPostService {
    GenericResponseDTO savePost(PostDTO post);

    FollowingPostDTO searchPostsOrderedByDate(Integer userId, String order);
    FollowingPostDTO searchPostsOnSale(Integer userId);
}