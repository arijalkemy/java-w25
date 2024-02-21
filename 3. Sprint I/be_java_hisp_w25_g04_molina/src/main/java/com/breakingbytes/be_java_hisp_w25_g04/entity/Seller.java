package com.breakingbytes.be_java_hisp_w25_g04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seller extends User{

    List<User> followers;
    List<Post> posts;

    public Seller() {
        super();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Seller(List<User> followers, List<Post> posts) {
        this.followers = followers;
        this.posts = posts;
    }

    public void addFollower(User user){
        this.followers.add(user);
    }
}
