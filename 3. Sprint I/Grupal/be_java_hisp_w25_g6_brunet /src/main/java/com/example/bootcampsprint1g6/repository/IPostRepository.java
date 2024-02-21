package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();
    Post save(Post post);
    Post findById(Integer id);
}
