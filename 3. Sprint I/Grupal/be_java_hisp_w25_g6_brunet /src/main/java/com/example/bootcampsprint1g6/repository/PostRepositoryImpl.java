package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    private List<Post> listOfPosts = new ArrayList<>();
    private Integer index = 0;

    @Override
    public List<Post> findAll(){
        return listOfPosts;
    }

    @Override
    public Post save(Post post){
        post.setPostId(index);
        listOfPosts.add(post);
        index++;
        return post;
    }
    @Override
    public Post findById(Integer id){
        return listOfPosts.stream().filter(p->p.getPostId().equals(id)).findFirst().orElse(null);
    }
}
