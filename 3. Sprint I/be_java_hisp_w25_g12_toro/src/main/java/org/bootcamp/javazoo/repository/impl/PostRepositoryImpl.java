package org.bootcamp.javazoo.repository.impl;

import lombok.Getter;
import lombok.Setter;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;

import org.bootcamp.javazoo.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private List<Post> posts = new ArrayList<>();
    @Getter
    @Setter
    private Integer counter = 0;

    public PostRepositoryImpl() {
        Product product1 = new Product(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        Product product2 = new Product(2, "Smartphone", "Electronics", "BrandY", "Negro", "Usado");

        Post post1 = new Post(1, LocalDate.now(), product1, 1, 500.0, false, 0.0);
        Post post2 = new Post(2, LocalDate.now().minusDays(5), product2, 2, 300.0, false, 0.0);
        Post post3 = new Post(3, LocalDate.now().minusWeeks(2), product1, 1, 250.0, false, 0.0);
        Post post4 = new Post(4, LocalDate.now().minusDays(3), product2, 2, 300.0, true, 0.2);
        Post post5 = new Post(5, LocalDate.now().minusWeeks(1), product1, 1, 250.0, true, 0.1);
        this.setCounter(6);

        this.posts.add(post1);
        this.posts.add(post2);
        this.posts.add(post3);
        this.posts.add(post4);
        this.posts.add(post5);

    }
    @Override
    public List<Post> getAll(){return posts;}

    @Override
    public void addNewPost(Post post){
        posts.add(post);
        this.setCounter(this.getCounter() + 1);
    }

    @Override
    public Post getById(Integer postId){
        return posts.stream().filter(post -> post.getId().equals(postId)).findFirst().orElse(null);
    }
}
