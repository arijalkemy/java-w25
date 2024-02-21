package com.grupo08.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Product;

@Repository
public class PostRepositoryImp implements IPostRepository {
    List<Post> listPosts = new ArrayList<>();

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
        return listPosts.stream().filter(p->p.getUserId()==idUser).toList();
    }

}
