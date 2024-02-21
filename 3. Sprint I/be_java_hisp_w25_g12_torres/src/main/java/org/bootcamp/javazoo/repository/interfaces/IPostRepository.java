package org.bootcamp.javazoo.repository.interfaces;

import org.bootcamp.javazoo.entity.Post;

import java.util.List;

public interface IPostRepository {
    Integer getCounter();
    List<Post> getAll();

    void addNewPost(Post post);

    Post getById(Integer postId);

}
