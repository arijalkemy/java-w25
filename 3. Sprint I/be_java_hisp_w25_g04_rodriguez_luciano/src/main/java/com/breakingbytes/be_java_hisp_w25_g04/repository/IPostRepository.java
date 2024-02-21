package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();
    void addPost(Post post);
    public List<Post> findPostByUser(int userID);
}
