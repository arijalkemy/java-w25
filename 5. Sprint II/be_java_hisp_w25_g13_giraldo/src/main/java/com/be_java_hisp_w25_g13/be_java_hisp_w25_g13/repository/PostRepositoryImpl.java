package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    List<Post> posts = new ArrayList<>();

    private static Integer idCount = 0;
    @Override
    public Post addPost(Post post) {
        post.setPostId(idCount++);
        posts.add(post);
        return post;
    }
    @Override
    public List<Post> filterByUserIdAndBetweenDate(Integer userId, LocalDate initDate, LocalDate endDate) {
        return posts.stream().
            filter(post -> (post.getDate().isAfter(initDate) || post.getDate().isEqual(initDate))
                && (post.getDate().isBefore(endDate) || post.getDate().isEqual(endDate)))
            .toList();
    }

    public void deleteById(Integer id){
        Optional<Post> toRemove = posts.stream().filter(p -> p.getPostId().equals(id)).findFirst();
        toRemove.ifPresent(post -> posts.remove(post));
    }

    public void cleanData(){
        this.posts = new ArrayList<>();
        idCount = 0;
    }
}
