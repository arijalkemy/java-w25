package org.bootcamp.javazoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private List<Integer> followed = new ArrayList<>();

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addFollowed(Integer userId) {
        followed.add(userId);
    }

    public void removeFollowed(Integer userId) {
        followed.remove(userId);
    }
}
