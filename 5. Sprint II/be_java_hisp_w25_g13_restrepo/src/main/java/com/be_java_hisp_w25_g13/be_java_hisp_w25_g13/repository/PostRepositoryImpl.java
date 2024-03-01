package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
