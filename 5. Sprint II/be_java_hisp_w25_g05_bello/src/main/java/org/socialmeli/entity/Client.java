package org.socialmeli.entity;

import lombok.Data;

import java.util.List;

@Data
public class Client extends User {
    public Client() {
    }

    public Client(Integer userId, String userName, List<Vendor> following) {
        super(userId, userName, following);
    }
}