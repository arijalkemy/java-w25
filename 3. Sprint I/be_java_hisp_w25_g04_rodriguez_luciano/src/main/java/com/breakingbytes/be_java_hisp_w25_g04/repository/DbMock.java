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
        User carlos = new User(); // ID: 2
        pepe.setName("Pepe");
        this.listOfUsers.add(pepe);
        carlos.setName("Carlos");
        this.listOfUsers.add(carlos);

        this.listOfSellers = new ArrayList<>();
        User juan = new User();
        juan.setName("Juan");
        this.listOfUsers.add(juan);
        Seller juanVendedor = new Seller(); // ID: 3
        juanVendedor.setUser(juan);
        juanVendedor.addFollower(pepe);
        this.listOfSellers.add(juanVendedor);
        User robert = new User();
        this.listOfUsers.add(robert);
        Seller robertVendedor = new Seller(); // ID: 4
        robert.setName("Robert");
        robertVendedor.setUser(robert);
        robertVendedor.addFollower(carlos);
        this.listOfSellers.add(robertVendedor);

        Product p1 = new Product("Laptop", "Electronics", "Dell", "Silver", "Thin and lightweight design");
        Product p2 = new Product("AAAAAAAA", "Electronics", "Samsung", "Black", "5G capable");
        Product p3 = new Product( "Running Shoes", "Apparel", "Nike", "Blue", "Breathable mesh upper");
        Product p4 = new Product("Headphones", "Electronics", "Sony", "Red", "Noise-canceling feature");
        Product p5 = new Product("Backpack", "Accessories", "JanSport", "Gray", "Multiple compartments");
        this.listOfProduct = new ArrayList<>(List.of(p1, p2, p3, p4, p5));

        Post post1 = new Post(LocalDate.of(2024,02,20), p2, 100, 1500.0);
        post1.setSeller(juanVendedor);
        Post post2 = new Post(LocalDate.of(2023,02,20), p3, 100, 1000.0);
        post2.setSeller(juanVendedor);
        Post post3 = new Post( LocalDate.of(2021,10,19), p1, 200, 240.0);
        post3.setSeller(robertVendedor);
        Post post4 = new Post(LocalDate.of(2019,02,21), p4, 100, 20.0);
        post4.setSeller(robertVendedor);
        Post post5 = new Post(LocalDate.of(2019,02,26), p5, 300, 30.0);
        post5.setSeller(robertVendedor);
        this.listOfPost = new ArrayList<>(List.of(post1, post2, post3, post4, post5));

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
