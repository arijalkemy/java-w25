package com.example.be_java_hisp_w25_g10.services.posts;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.PromoDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.SummaryPromotionsDto;

import java.util.List;

public interface IPostService {
    PostsDto getPostsFollowed(int userId, String sortOrder);
    PostCreatedDto createPost(PostCreatedDto post);
    List<PostCreatedDto> verPosts();

    PromoDto createPromo(PromoDto dto);

    SummaryPromotionsDto getSummaryPromotions(int userId);
}
