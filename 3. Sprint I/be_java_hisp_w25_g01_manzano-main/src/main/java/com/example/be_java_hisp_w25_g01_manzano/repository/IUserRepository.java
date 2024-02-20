package com.example.be_java_hisp_w25_g01_manzano.repository;

import com.example.be_java_hisp_w25_g01_manzano.entity.Post;
import com.example.be_java_hisp_w25_g01_manzano.entity.User;

import java.util.List;
import java.util.Optional;
public interface IUserRepository {

    List<User> findAll();

    Optional<User> findById(Integer id);

    public void followUser(Integer UserId, Integer userIdToFollow);

    public void unfollowUser(Integer UserId, Integer userIdToUnfollow);

    public void createPost(Post post);
    List<User> findAllByIdIn(List<Integer> userIds);
}
