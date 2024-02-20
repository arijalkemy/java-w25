package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowedPostDto;

import java.util.List;

public interface IPostService {

    MessageDto savePost(PostDto postDto);
    List<PostDto> getAllPosts();
    UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted);

}
