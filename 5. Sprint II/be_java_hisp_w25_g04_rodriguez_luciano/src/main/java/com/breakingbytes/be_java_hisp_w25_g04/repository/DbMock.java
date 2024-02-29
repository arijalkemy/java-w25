package com.breakingbytes.be_java_hisp_w25_g04.repository;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;

import java.nio.channels.spi.SelectorProvider;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbMock {
    private static DbMock dbMock;
    private List<User> listOfUsers;
    private List<Seller> listOfSellers;
    private List<Post> listOfPost;
    private List<Product> listOfProduct;
    private DbMock(){
        this.listOfUsers = new ArrayList<>();
        User pepe = new User(); // ID: 1
        pepe.setId(1);
        User carlos = new User(); // ID: 2
        carlos.setId(2);
        pepe.setName("Pepe");
        this.listOfUsers.add(pepe);
        carlos.setName("Carlos");
        this.listOfUsers.add(carlos);

        this.listOfSellers = new ArrayList<>();
        Seller juan = new Seller(); // ID: 3
        juan.setName("Juan");
        juan.setId(3);
        pepe.addFollowing(juan);
        juan.addFollower(pepe);
        this.listOfSellers.add(juan);
        Seller robert = new Seller(); // ID: 4
        robert.setId(4);
        robert.setName("Robert");
        robert.addFollower(carlos);
        carlos.addFollowing(robert)
        ;
        this.listOfSellers.add(robert);

        Product p1 = new Product(1, "Laptop", "Electronics", "Dell", "Silver", "Thin and lightweight design");
        Product p2 = new Product(2, "AAAAAAAA", "Electronics", "Samsung", "Black", "5G capable");
        Product p3 = new Product(3, "Running Shoes", "Apparel", "Nike", "Blue", "Breathable mesh upper");
        Product p4 = new Product(4, "Headphones", "Electronics", "Sony", "Red", "Noise-canceling feature");
        Product p5 = new Product(5, "Backpack", "Accessories", "JanSport", "Gray", "Multiple compartments");
        this.listOfProduct = new ArrayList<>(List.of(p1, p2, p3, p4, p5));

        Post post1 = new Post(3, LocalDate.of(2024,2,20), p2, 100, 1500.0);
        Post post2 = new Post(3, LocalDate.of(2023, 2,20), p3, 100, 1000.0);
        Post post3 = new Post(4, LocalDate.of(2021,10,19), p1, 200, 240.0);
        Post post4 = new Post(3, LocalDate.of(2019,2,21), p4, 100, 20.0);
        Post post5 = new Post(3, LocalDate.of(2019,2,26), p5, 300, 30.0);
        this.listOfPost = new ArrayList<>(List.of(post1, post2, post3, post4, post5));

        juan.getPosts().add(post1);
        juan.getPosts().add(post2);
        robert.getPosts().add(post3);
        juan.getPosts().add(post4);
        juan.getPosts().add(post5);
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public List<Seller> getListOfSellers() {
        return listOfSellers;
    }

    public List<Post> getListOfPost() {
        return listOfPost;
    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    public static DbMock getInstance(){
        if(dbMock == null){
            dbMock = new DbMock();
        }
        return  dbMock;
    }

}
