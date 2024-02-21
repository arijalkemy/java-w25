package com.example.be_java_hisp_w25_g10.services.posts;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.DTO.ResponseDto;
import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;

import java.util.List;

public interface IPostService {
    PostsDto getPostsFollowed(int userId, String sortOrder);
    PostCreatedDto createPost(PostCreatedDto post);
    List<PostCreatedDto> verPosts();
}
