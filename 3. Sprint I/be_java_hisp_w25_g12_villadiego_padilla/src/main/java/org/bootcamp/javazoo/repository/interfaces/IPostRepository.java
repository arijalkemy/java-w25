package org.bootcamp.javazoo.repository.interfaces;

import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.PostPromo;

import java.util.List;

public interface IPostRepository {
    List<Post> getAll();
    List<PostPromo> getAllPromo();

    void addNewPost(Post post);
    void addNewPostPromo(PostPromo postPromo);

}
