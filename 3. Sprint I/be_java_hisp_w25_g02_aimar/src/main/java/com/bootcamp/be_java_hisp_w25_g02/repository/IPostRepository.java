package com.bootcamp.be_java_hisp_w25_g02.repository;

import java.util.List;
import java.util.Optional;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;

public interface IPostRepository {
    Optional<Post> findById(Integer id);
    List<Post> findAll();
    Optional<Product> findProductById(int id);
    long savePost(Post post);
    List<Post> findByUserId(Integer userId);
    void deletePost(Post post);
    void updatePost(Integer id, Post post);
}
