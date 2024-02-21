package com.socialMeli.repository;

import com.socialMeli.entity.Post;

import java.util.List;
import java.util.Optional;

import com.socialMeli.entity.Post;
import com.socialMeli.entity.Product;

public interface IPostRepository {
    Optional<List<Post>> getPostFromTheLastTwoWeeksByUserId(Integer userId);
    Integer add(Post post);
}
