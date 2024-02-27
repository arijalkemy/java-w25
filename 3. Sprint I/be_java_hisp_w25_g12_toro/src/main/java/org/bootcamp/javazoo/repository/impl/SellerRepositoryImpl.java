package org.bootcamp.javazoo.repository.impl;

import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.repository.interfaces.ISellerRepository;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImpl implements ISellerRepository {
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImpl() {
        List<Integer> followers = new ArrayList<>();
        followers.add(4);
        List<Integer> posts = new ArrayList<>();
        posts.add(1);
        posts.add(2);
        posts.add(3);
        posts.add(4);
        posts.add(5);
        Seller seller1 = new Seller(1, "Seller 1", followers, posts);
        Seller seller2 = new Seller(2, "Seller 2");
        Seller seller3 = new Seller(3, "Seller 3");
        sellers.add(seller1);
        sellers.add(seller2);
        sellers.add(seller3);

    }
    @Override
    public Seller findById(Integer id) {
        return sellers.stream().filter(seller -> seller.getId().equals(id)).findFirst().orElse(null);
    }
}
