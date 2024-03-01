package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.Product;

import java.util.List;

public interface IPostRepo {

    void savePost(Post post);
    List<Post> getAllPosts();
    List<Post> getPostsById(Integer id);



}
