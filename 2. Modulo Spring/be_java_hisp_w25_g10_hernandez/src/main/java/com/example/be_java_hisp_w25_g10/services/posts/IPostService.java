package com.example.be_java_hisp_w25_g10.services.posts;

import com.example.be_java_hisp_w25_g10.dtos.CountPromoDto;
import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;

import java.util.List;

public interface IPostService {
    PostsDto getPostsFollowed(int userId, String sortOrder);
    PostCreatedDto createPost(PostCreatedDto post);
    List<PostCreatedDto> verPosts();
    public PostCreatedDto createPromoPost(PostCreatedDto newPost);
    public CountPromoDto countPromo(int userId);
}
