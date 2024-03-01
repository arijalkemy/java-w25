package com.example.be_java_hisp_w25_g11.utils;

import com.example.be_java_hisp_w25_g11.entity.*;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class    DataModeler {

    IBuyerRepository userRepository;
    ISellerRepository sellerRepository;
    ISellerPostRepository sellerPostRepository;

    public DataModeler(
            IBuyerRepository userRepository,
            ISellerRepository sellerRepository,
            ISellerPostRepository sellerPostRepository
    ) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.sellerPostRepository = sellerPostRepository;
    }

    @PostConstruct
    public void load() {

        List<Buyer> users = new ArrayList<>(List.of(
                new Buyer(1, "Jhon Perez"),
                new Buyer(2, "Carlos Martinez"),
                new Buyer(3, "Maria Rodriguez"),
                new Buyer(4, "Pedro Lopez"),
                new Buyer(5, "Eduardo Gomez")
        ));

        List<Seller> sellers = new ArrayList<>(List.of(
                new Seller(6, "Natalia Sanchez"),
                new Seller(7, "Samuel Diaz"),
                new Seller(8, "Jorge Hernandez"),
                new Seller(9, "Oscar Ramirez"),
                new Seller(10, "Diego Gonzalez"),
                new Seller(11, "Juan Torres"),
                new Seller(12, "Andres Flores")
        ));

        List<Product> products = new ArrayList<>(List.of(
                new Product(1, "Monitor", "Oficina", "Samsumg", "Black", "1080p"),
                new Product(2, "Silla Gamer", "Gamer", "Razer", "Black", "Special Edition"),
                new Product(3, "Mouse", "Personal", "Apple", "White", "Only for Mac"),
                new Product(4, "Teclado", "Gamer", "Logitech", "White", "With RGB"),
                new Product(5, "Audífonos", "Studio", "Beats", "Red", "Wireless")
        ));

        List<SellerPost> posts = new ArrayList<>(List.of(
                new SellerPost(6, 1, LocalDate.of(2022,2,15), products.get(0), 10, 0.0, sellers.get(0)),
                new SellerPost(7, 2, LocalDate.of(2021,4,28), products.get(1), 10, 0.0, sellers.get(0)),
                new SellerPost(8, 3, LocalDate.of(2019,5,18), products.get(2), 10, 0.0, sellers.get(0)),
                new SellerPost(9, 4, LocalDate.of(2017,6,7), products.get(3), 10, 0.0, sellers.get(0)),
                new SellerPost(10, 5, LocalDate.of(2022,9,4), products.get(4), 10, 0.0, sellers.get(0))
        ));

        // Assign posts to sellers
        sellers.get(0).getPosts().add(posts.get(0));
        sellers.get(0).getPosts().add(posts.get(1));
        sellers.get(1).getPosts().add(posts.get(2));
        sellers.get(2).getPosts().add(posts.get(3));
        sellers.get(3).getPosts().add(posts.get(4));

        // Set followed
        users.get(0).setFollowed(new HashSet<>(List.of(
                sellers.get(0).getId(),
                sellers.get(1).getId(),
                sellers.get(2).getId()
        )));

        users.get(1).setFollowed(new HashSet<>(List.of(
                sellers.get(0).getId(),
                sellers.get(2).getId()
        )));

        users.get(2).setFollowed(new HashSet<>(List.of(
                sellers.get(1).getId(),
                sellers.get(2).getId(),
                sellers.get(3).getId()
        )));

        users.get(4).setFollowed(new HashSet<>(List.of(
                sellers.get(3).getId()
        )));

        sellers.get(3).setFollowed(new HashSet<>(List.of(
                sellers.get(1).getId(),
                sellers.get(2).getId()
        )));

        // Set followers

        sellers.get(0).setFollowers(new HashSet<>(List.of(
                users.get(0).getId(),
                users.get(1).getId()
        )));

        sellers.get(1).setFollowers(new HashSet<>(List.of(
                users.get(0).getId(),
                users.get(2).getId(),
                sellers.get(3).getId()
        )));

        sellers.get(2).setFollowers(new HashSet<>(List.of(
                users.get(0).getId(),
                users.get(1).getId(),
                users.get(2).getId(),
                sellers.get(3).getId()
        )));

        sellers.get(3).setFollowers(new HashSet<>(List.of(
                users.get(2).getId(),
                users.get(4).getId()
        )));

        // Add everything to repositories
        userRepository.createAll(users);
        sellerRepository.createAll(sellers);
        sellerPostRepository.createAll(posts);
    }
}