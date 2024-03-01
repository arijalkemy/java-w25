package org.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Vendor extends User {
    private List<User> followers;

    public Vendor() {
        this.followers = new ArrayList<>();
    }

    public Vendor(Integer userId, String userName, List<Vendor> following, List<User> followers) {
        super(userId, userName, following);
        this.followers = followers;
    }
}

