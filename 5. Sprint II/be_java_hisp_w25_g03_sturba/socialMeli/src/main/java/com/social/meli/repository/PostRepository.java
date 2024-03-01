package com.social.meli.repository;

import com.social.meli.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository {

    List<Post> postBd;

    public PostRepository() {
        this.postBd = new ArrayList<>();
        postBd.add(new Post(1,LocalDate.now(),1,1,2.0,8));
    }

    @Override
    public Integer add(Post post) {
        this.postBd.add(post);
        return post.getId();
    }
    Period twoWeeksPeriod = Period.ofWeeks(2);

    @Override
    public Optional<List<Post>> getPostFromTheLastTwoWeeksByUserId(Integer userId) {
        List<Post> filteredPost = postBd.stream().filter(
                post -> post.getUserId().equals(userId) &&
                        post.getDate().isAfter(LocalDate.now().minus(twoWeeksPeriod))
        ).toList();
        return filteredPost.isEmpty() ? Optional.empty() : Optional.of(filteredPost);
    }
}
