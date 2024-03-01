package org.socialmeli.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class User {
    protected Integer userId;
    protected String userName;
    protected List<Vendor> following;
    public static Integer userIdCounter = 0;

    public User() {
        this.userId = null;
        this.userName = null;
        this.following = new ArrayList<>();
    }

    public User(Integer userId, String userName, List<Vendor> following) {
        this.userId = userId;
        this.userName = userName;
        this.following = following;
    }
}