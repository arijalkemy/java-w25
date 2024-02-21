package com.breakingbytes.be_java_hisp_w25_g04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seller{
    User user;
    List<User> followers;

    public Seller() {
        super();
        this.followers = new ArrayList<>();
    }

    public Seller(List<User> followers) { this.followers = followers; }

    public void addFollower(User user){
        this.followers.add(user);
    }
    public void removeFollower(User user) { this.followers.remove(user); }

    public boolean isAFollower(User user) { return this.getFollowers().contains(user); }

}
