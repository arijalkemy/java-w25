package com.bootcamp.be_java_hisp_w25_g9.repository.interfaces;

import com.bootcamp.be_java_hisp_w25_g9.model.Post;

import java.util.List;

public interface IPostRepository {

    public void addPost(Post post);

    public List<Post> findAll();

}
