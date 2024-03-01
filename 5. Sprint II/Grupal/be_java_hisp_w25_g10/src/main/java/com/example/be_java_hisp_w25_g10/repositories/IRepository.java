package com.example.be_java_hisp_w25_g10.repositories;

import com.example.be_java_hisp_w25_g10.entities.Follower;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.User;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    List<Post> getPosts();

    Optional<Follower> follow(int userId, int followedId);

    Optional<User> findUser(int id);

    void unFollow(int userId, int followedId);
    List<User> getFollowersList(int userId);
    List<User> getFollowedList(int userId);

    List<Post> getFollowedPosts(int userId);
    Post addPost(Post newPost);
    List<Post> verPost();
    List<User> getSellers();
    boolean validatePost (int id);
}