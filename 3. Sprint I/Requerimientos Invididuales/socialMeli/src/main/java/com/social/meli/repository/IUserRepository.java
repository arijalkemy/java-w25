package com.social.meli.repository;

import com.social.meli.entity.User;

import java.util.List;

import java.util.Optional;


public interface IUserRepository {


    Optional<User> findUserByUserId(Integer userId);
    List<User> getAllFollowers(List<Integer> followersIds);
    void unfollowUser(User user, User userToUnfollow);
    void followUser(User user, User userToFollow);
}
