package com.bootcamp.be_java_hisp_w25_g14_Lozano.service;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.*;

import java.util.List;

public interface IPostService {

    MessageDto savePost(PostDto postDto);
    List<PostDto> getAllPosts();
    UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted);

    public ProductPromoCountDto getProductPostCount(Integer userId);

    public List<PostDto>  listProductPostCount(Integer userId);
}
