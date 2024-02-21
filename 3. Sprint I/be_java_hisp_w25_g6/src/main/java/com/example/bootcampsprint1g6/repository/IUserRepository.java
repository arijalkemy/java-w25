package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    User save(User user);
    Optional<User> findById(Integer id);
  
    List<Seller> getFollowedList(Integer userId);
    List<User> getFollowersList(Integer userId);
    User addPostToUser(Post post);
}
