package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;

import java.util.List;

public interface IPostService {

    MessageDto savePost(PostDto postDto);

    MessageDto savePostDiscount(PostFullDto postFullDto);
    List<PostDto> getAllPosts();

    List<PostFullDto> getAllPostsFull();
    List<PostFullDto> getPostOnDiscountBySeller(Integer id);

    PostOnDiscountCountDto postOnDiscountCountBySeller(Integer id);
    UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted);



}
