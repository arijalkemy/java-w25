package com.bootcamp.be_java_hisp_w25_g14_Lozano.repository;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.entity.Post;

import java.util.List;

public interface IPostRepo {

    void savePost(Post post);
    List<Post> getAllPosts();
    List<Post> getPostsById(Integer id);


}
