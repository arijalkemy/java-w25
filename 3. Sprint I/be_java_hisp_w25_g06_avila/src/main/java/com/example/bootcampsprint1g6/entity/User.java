package com.example.bootcampsprint1g6.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    Integer userId;
    String userName;
    String email;

    List<Seller> followed = new ArrayList<>();

    public User(Integer userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public abstract void follow(Seller seller);
    public abstract void unfollow(Seller seller);

}
