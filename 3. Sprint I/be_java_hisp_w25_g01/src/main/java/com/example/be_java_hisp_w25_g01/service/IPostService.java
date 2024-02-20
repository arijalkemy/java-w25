package com.example.be_java_hisp_w25_g01.service;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import org.springframework.stereotype.Service;

public interface IPostService {


    PostsListDTO getLastPostsFollowedBy(Integer userId);

    MessagesDTO followUser (int userId);

    MessagesDTO createPost(PostDTO post);


}
