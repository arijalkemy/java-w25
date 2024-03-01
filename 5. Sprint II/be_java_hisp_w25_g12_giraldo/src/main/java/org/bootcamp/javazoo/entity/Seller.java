package org.bootcamp.javazoo.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Seller extends User {
    private List<Integer> followers = new ArrayList<>();
    private List<Integer> posts = new ArrayList<>();

    public Seller(Integer id, String name, List<Integer> followers, List<Integer> posts) {
        super(id, name);
        this.followers = followers;
        this.posts = posts;
    }

    public Seller(Integer id, String name) {
        super(id, name);
    }

    public void addFollower(Integer userId) {
        followers.add(userId);
    }
    public void addPost(Integer postId) {
        posts.add(postId);
    }
}


