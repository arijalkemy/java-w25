package com.social.meli.repository;

import com.social.meli.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    Optional<List<Post>> getPostFromTheLastTwoWeeksByUserId(Integer userId);
    Integer add(Post post);
}
