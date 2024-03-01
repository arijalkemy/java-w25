package com.grupo08.socialmeli.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Product;

@Repository
public class PostRepositoryImp implements IPostRepository {
    private static final List<Post> listPosts = new ArrayList<>();

public PostRepositoryImp(){

    // Objeto 1
    Post post1 = new Post(1, LocalDate.of(2024, 2, 28), null, 1, 10.0);
    this.listPosts.add(post1);

    // Objeto 2
    Post post2 = new Post(1, LocalDate.of(2024, 2, 27), null, 1, 10.0);
    this.listPosts.add(post2);

    // Objeto 3
    Post post3 = new Post(1, LocalDate.of(2024, 2, 25), null, 1, 10.0);
    this.listPosts.add(post3);

    // Objeto 4
    Post post4 = new Post(1, LocalDate.of(2024, 2, 29), null, 1, 10.0);
    this.listPosts.add(post4);
}
    @Override
    public void insertPost(Post post){
        listPosts.add(post);
        System.out.println("Post añadido");
    }

    @Override
    public List<Post> getAll() {
        return listPosts;
    }

    @Override
    public Optional<Post> getPostByProductId(int productId) {
        Optional<Post> getPost = listPosts.stream()
                                                .filter(post -> post.getProduct().getProductId() == productId)
                                                .findFirst();
        return getPost;
    }

    @Override
    public List<Post> getByIdUser(Long idUser) {
        return listPosts.stream().filter(p->p.getUserId()==idUser.longValue()).toList();
    }

}
