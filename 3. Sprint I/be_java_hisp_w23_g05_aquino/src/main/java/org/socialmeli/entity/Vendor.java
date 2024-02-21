package org.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class Vendor extends User {
    private List<User> followers;

    public Vendor() {
        this.followers = new ArrayList<>();
    }
}

