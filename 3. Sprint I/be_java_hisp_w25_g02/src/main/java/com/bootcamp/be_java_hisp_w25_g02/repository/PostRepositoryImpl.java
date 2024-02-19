package com.bootcamp.be_java_hisp_w25_g02.repository;

import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PostRepositoryImpl implements IPostRepository
{
    List<Post> postList = new ArrayList<>(List.of(

            new Post(0, 1, LocalDate.of(2000, 01, 01),
                    new Product(0, "Pelopincho", "Piletas", "XXX", "Azul", "2000 litros"), 2, 52000.0),
            new Post(1,
                   2, LocalDate.of(2005, 02, 10),
                    new Product(1, "Lentes de sol", "Lentes", "Ray Ban", "Gris", "Lorem ipsum"), 3, 13500.0),

            new Post(3, 7, LocalDate.of(2024, 02, 17),
                    new Product(2, "Pelopincho", "Piletas", "XXX", "Azul", "2000 litros"), 2, 52000.0),
            new Post(4,
                   7, LocalDate.of(2024, 02, 19),
                    new Product(3, "Lentes de sol", "Lentes", "Ray Ban", "Gris", "Lorem ipsum"), 3, 13500.0),
            new Post(5, 9, LocalDate.of(2024, 02, 18),

                    new Product(4, "Mouse gamer", "Informática", "Logitech", "Gris", "Lorem ipsum"), 4, 7500.0)
            ));


    @Override
    public Optional<Post> findById(Integer id) {
        return this.postList.stream().filter(post -> Objects.equals(post.getPost_id(), id)).findFirst();
    }

    @Override
    public List<Post> findAll() {
        return this.postList;
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return this.postList.stream().filter(post -> post.getProduct().getProduct_id() == id).map(Post::getProduct).findFirst();
    }

    @Override
    public long savePost(Post post) {
        post.setPost_id( postList.size());
        postList.add(post);
        return post.getPost_id();
}
    public List<Post> findByUserId(Integer userId) {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        return this.postList.stream().filter(post -> post.getPostDate().isAfter(twoWeeksAgo) && Objects.equals(post.getUser_id(), userId)).toList();

    }
}
