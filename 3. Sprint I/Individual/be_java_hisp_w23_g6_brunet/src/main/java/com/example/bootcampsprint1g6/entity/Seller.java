package com.example.bootcampsprint1g6.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User {
    List<User> followers = new ArrayList<>();
    List<Post> posts = new ArrayList<>();

    public Seller(Integer userId, String userName, String email) {
        super(userId, userName, email);
    }

    @Override
    public void follow(Seller seller){
        followed.add(seller);
        seller.addFollower(this);
    }

    public void addPost(Post post){
        posts.add(post);
    }
    
    public void addFollower(User user){
        if (followers.stream().noneMatch(f -> f.getUserId().equals(user.getUserId())))
            followers.add(user);
    }
    @Override
    public void unfollow(Seller seller){
        this.followed.remove(seller);
        seller.removeFollower(this);
    }
    public void removeFollower(User user){
        followers.removeIf(u -> u.getUserId().equals(user.getUserId()));
    }
}
