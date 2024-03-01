package com.socialMeli.repository;

import com.socialMeli.entity.Post;
import com.socialMeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

    List<Post> postBd = new ArrayList<>();

    public PostRepository() {
        this.postBd.add(new Post(1, LocalDate.now(), 1,
                100, 1500.50, 10));
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
