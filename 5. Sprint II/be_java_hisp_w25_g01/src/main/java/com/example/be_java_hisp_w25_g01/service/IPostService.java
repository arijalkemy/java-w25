package com.example.be_java_hisp_w25_g01.service;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;

public interface IPostService {


    PostsListDTO getLastPostsFollowedBy(Integer userId, String order);//+ el parametro order

    MessagesDTO followUser (int userId);

    MessagesDTO createPost(PostDTO post);
}
