package com.grupo08.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo08.socialmeli.dto.response.PromoPostxSellerDto;
import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Product;
import com.grupo08.socialmeli.entity.User;
import com.grupo08.socialmeli.exception.NotFoundException;

@Repository
public class PostRepositoryImp implements IPostRepository {

    @Autowired
    ISellerRepository sellerRepository;

    List<Post> listPosts = new ArrayList<>() {{
        add(new Post(
            123, 
            "19-02-2024", 
            new Product(
                123, 
                "Silla Gamer", 
                "Gamer", 
                "Racer", 
                "Red & Black", 
                "Special Edition"
            ),
            1, 
            50000.0,
            false,
            0.0
        ));
    }};

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
    public PromoPostxSellerDto getPromoPostxSeller(int user_id) {
        List<Post> getPostsSeller = listPosts.stream()
                                            .filter(p -> p.getUserId().equals(user_id) && p.isHas_promo() == true)
                                            .toList();
        if (getPostsSeller.isEmpty()) 
            throw new NotFoundException("Vendedor no tiene productos en promocion");

        User user = sellerRepository.findById(user_id).get();
        PromoPostxSellerDto promoPostxSellerDto = new PromoPostxSellerDto(
            user.getId(),
            user.getName(),
            getPostsSeller.size()
        );
        return promoPostxSellerDto;              


    }

}
