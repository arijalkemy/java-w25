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
    List<Product> productBd;
    List<Post> postBd;

    public PostRepository() {
        this.productBd = new ArrayList<>();
        this.postBd = new ArrayList<>();
    }

    @Override
    public Integer add(Post post) {
        this.postBd.add(post);
        return post.getId();
    }

    @Override //Ej11
    public Integer getPromosCountByIdVendor(Integer userId) {
        return Math.toIntExact(postBd.stream().filter(Post::getHas_promo).count());
    }

    @Override
    public List<Post> getPromosByIdVendor(Integer userId) {
        return postBd.stream()
                .filter(post -> userId.equals(post.getUserId()) && post.getHas_promo())
                .toList();
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
