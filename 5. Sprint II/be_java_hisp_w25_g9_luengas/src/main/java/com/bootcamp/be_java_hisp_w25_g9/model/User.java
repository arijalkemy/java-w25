package com.bootcamp.be_java_hisp_w25_g9.model;

import java.util.Arrays;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class User {
    private Integer userId;
    private String userName;
    private List<Seller> followed;

    public User(Integer userId, String userName){
        this.userId = userId;
        this.userName = userName;
        this.followed = new ArrayList<>();
    }
}
