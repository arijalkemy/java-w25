package com.example.bootcampsprint1g6.repository.implementation;

import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    private List<Post> listOfPosts = new ArrayList<>();
    private Integer index = 0;

    @Override
    public Post save(Post post){
        post.setPostId(index);
        listOfPosts.add(post);
        index++;
        return post;
    }
}
