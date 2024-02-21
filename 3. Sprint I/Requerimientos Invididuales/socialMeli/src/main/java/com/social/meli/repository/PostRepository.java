package com.social.meli.repository;

import com.social.meli.entity.PromoPost;
import com.social.meli.entity.Post;
import com.social.meli.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository {
    List<Product> productBd;
    List<Post> postBd;
    Period twoWeeksPeriod = Period.ofWeeks(2);

    public PostRepository() {
        this.productBd = new ArrayList<>();
        this.postBd = new ArrayList<>();
    }
    @Override
    public Integer add(Post post) {
        this.postBd.add(post);
        return post.getId();
    }
    @Override
    public Post findPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PromoPost> findPromoPostsByUserId(Integer userId) {
        return postBd.stream().filter(p -> p.getUserId().equals(userId) && p instanceof PromoPost).map(PromoPost.class::cast).toList();
    }

    @Override
    public Optional<List<Post>> getPostFromTheLastTwoWeeksByUserId(Integer userId) {
        List<Post> filteredPost = postBd.stream().filter(
                post -> post.getUserId().equals(userId) &&
                        post.getDate().isAfter(LocalDate.now().minus(twoWeeksPeriod))
        ).toList();
        return filteredPost.isEmpty() ? Optional.empty() : Optional.of(filteredPost);
    }
}
