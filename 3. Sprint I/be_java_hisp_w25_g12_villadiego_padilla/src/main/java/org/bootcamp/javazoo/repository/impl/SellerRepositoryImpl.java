package org.bootcamp.javazoo.repository.impl;

import org.bootcamp.javazoo.entity.*;
import org.bootcamp.javazoo.repository.interfaces.ISellerRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImpl implements ISellerRepository {
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImpl() {
        Product product1 = new Product(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        Product product2 = new Product(2, "Smartphone", "Electronics", "BrandY", "Negro", "Usado");

        Seller seller1 = new Seller(1, "Seller 1");
        Seller seller2 = new Seller(2, "Seller 2");
        Seller seller3 = new Seller(3, "Seller 3");
        User user1 = new User(5, "User 1");
        User user2 = new User(7, "User 7");

        Post post1 = new Post(1, seller1, LocalDate.now(), product1, 1, 500.0);
        Post post2 = new Post(2, seller2, LocalDate.now().minusDays(5), product2, 2, 300.0);
        Post post3 = new Post(3, seller1, LocalDate.now().minusWeeks(2), product1, 1, 250.0);

        PostPromo post4 = new PostPromo(1, seller1, LocalDate.now(), product1, 1, 500.0, true, 0.25);
        PostPromo post5 = new PostPromo(2, seller2, LocalDate.now().minusDays(5), product2, 2, 300.0, true, 0.25);
        PostPromo post6 = new PostPromo(3, seller3, LocalDate.now().minusWeeks(2), product1, 1, 250.0, true, 0.25);
        PostPromo post7 = new PostPromo(1, seller1, LocalDate.now(), product2, 1, 500.0, true, 0.50);

        seller1.getPosts().add(post1);
        seller2.getPosts().add(post2);
        seller1.getPosts().add(post3);

        seller1.getPostsPromo().add(post4);
        seller2.getPostsPromo().add(post5);
        seller3.getPostsPromo().add(post6);
        seller1.getPostsPromo().add(post7);


        seller1.getFollowers().add(user1);
        seller2.getFollowers().add(user1);
        seller2.getFollowers().add(user2);
        seller3.getFollowers().add(user1);

        user2.getFollowed().add(seller1);
        user2.getFollowed().add(seller2);
        user1.getFollowed().add(seller1);
        user1.getFollowed().add(seller2);

        sellers.add(seller1);
        sellers.add(seller2);
        sellers.add(seller3);


    }
    @Override
    public Seller findById(Integer id) {
        return sellers.stream().filter(seller -> seller.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void addFollower(User user, Seller seller) {
        List<User> updatedFollowers = new ArrayList<>(seller.getFollowers());
        updatedFollowers.add(user);
        seller.setFollowers(updatedFollowers);
    }

}
