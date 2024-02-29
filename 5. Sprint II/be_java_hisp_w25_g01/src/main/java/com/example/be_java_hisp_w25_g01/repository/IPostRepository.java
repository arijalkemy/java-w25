package com.example.be_java_hisp_w25_g01.repository;

import com.example.be_java_hisp_w25_g01.entity.Post;

import java.util.List;
import java.util.Optional;
public interface IPostRepository {
    public List<Post> getAll();
    public Optional<Post> findById(Integer id);
    public List<Post> findByUser(Integer userId);
    public void addPost(Post post);
    public Integer generateId();
    List<Post> findAllPostById(List<Integer> postIds);


}
