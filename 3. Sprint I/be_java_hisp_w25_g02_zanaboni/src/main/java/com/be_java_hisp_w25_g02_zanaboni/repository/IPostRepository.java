package com.be_java_hisp_w25_g02_zanaboni.repository;

import com.be_java_hisp_w25_g02_zanaboni.entity.Post;
import com.be_java_hisp_w25_g02_zanaboni.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {

    Optional<Post> findById(Integer id);
    List<Post> findAll();


    Optional<Product> findProductById(int id);

    long savePost(Post post);
    List<Post> findByUserId(Integer userId);
    List<Post> findOnSalePosts(Integer userId);
}
