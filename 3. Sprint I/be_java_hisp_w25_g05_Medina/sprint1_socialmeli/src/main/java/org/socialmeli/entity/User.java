package org.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
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
}