package com.breakingbytes.be_java_hisp_w25_g04.utils;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;


import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;


import com.breakingbytes.be_java_hisp_w25_g04.repository.DbMock;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FactoryUsers { // No es la base de dato

    private static FactoryUsers factoryUsers;
    private List<User> listOfUsers;
    private List<Seller> listOfSellers;
    private List<Post> listOfPost;
    private List<Product> listOfProduct;
    private ModelMapper mapper;
    private FactoryUsers(){
        this.listOfUsers = new ArrayList<>();
        User pepe = new User(); // ID: 1
        User carlos = new User(); // ID: 2
        pepe.setName("Pepe");
        this.listOfUsers.add(pepe);
        carlos.setName("Carlos");
        this.listOfUsers.add(carlos);

        this.listOfSellers = new ArrayList<>();
        Seller juan = new Seller(); // ID: 3
        juan.setName("Juan");
        pepe.addFollowing(juan);
        juan.addFollower(pepe);
        this.listOfSellers.add(juan);
        Seller robert = new Seller(); // ID: 4
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

        mapper = new ModelMapper();
    }

    public List<User> getListOfUsers() { return listOfUsers; }

    public User getUserByName(String name) {
        Optional<User> user = this.listOfUsers.stream().filter(u -> u.getName().equals(name)).findFirst();
        if(user.isEmpty()) throw new NotFoundException("No se encontró el usuario");
        return user.get();
    }

    public Seller getSellerByName(String name) {
        Optional<Seller> user = this.listOfSellers.stream().filter(u -> u.getName().equals(name)).findFirst();
        if(user.isEmpty()) throw new NotFoundException("No se encontró el usuario");
        return user.get();
    }

    public Seller createSeller(Integer id){
        Seller seller = new Seller();
        seller.setId(id);
        seller.setName("Matias");
        return seller;
    }
    public User createUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setName("Gabriel");
        return user;
    }

    public User getUserById(Integer id) {
        Optional<User> user = this.listOfUsers.stream().filter(u -> u.getId().equals(id)).findFirst();
        if(user.isEmpty()) throw new NotFoundException("No se encontró el usuario");
        return user.get();
    }

    public User getSellerById(Integer id) {
        Optional<Seller> seller = this.listOfSellers.stream().filter(u -> u.getId().equals(id)).findFirst();
        if(seller.isEmpty()) throw new NotFoundException("No se encontró al vendedor");
        return seller.get();
    }

    public static FactoryUsers getInstance(){
        if(factoryUsers == null) factoryUsers = new FactoryUsers();
        return factoryUsers;
    }

    public List<Post> getPostsDateDesc(){
        return this.getPostsWithoutOrder().stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
    }

    public List<Post> getPostsWithoutOrder(){
        Post p1 = new Post(3, LocalDate.now().minusWeeks(1), new Product(), 100, 1500.0);
        p1.setPostId(2);
        Post p2 = new Post(3, LocalDate.now(), new Product(), 100, 1500.0);
        p2.setPostId(3);
        Post p3 = new Post(3, LocalDate.now().minusDays(5), new Product(), 100, 1500.0);
        p3.setPostId(1);
        return new ArrayList<>(List.of(p1,p2,p3));
    }

    public List<Post> getPostsDateAsc(){
        return this.getPostsWithoutOrder().stream().sorted(Comparator.comparing(Post::getDate)).toList();
    }

    public List<ResponsePostDTO> convertPostToResponsePostDTO(List<Post> posts){
        return posts.stream().map(p ->
                new ResponsePostDTO(p.getUserId(),
                        p.getPostId(),
                        p.getDate(),
                        p.getProduct(),
                        p.getCategory(),
                        p.getPrice())).toList();
    }

    public LastPostsDTO generateLastPostDto() {
        User pepe = listOfUsers.get(0);
        List<ResponsePostDTO> postsDto = new ArrayList<>();
        for (Seller s : pepe.getFollowing()) {
            for (Post p : s.getPosts()) {
                if (!p.getDate().isBefore(LocalDate.now().minusWeeks(2))) {
                    ResponsePostDTO responsePostDTO = mapper.map(p, ResponsePostDTO.class);
                    responsePostDTO.setUserId(s.getId());
                    postsDto.add(responsePostDTO);
                }
            }
        }
        return new LastPostsDTO(pepe.getId(), postsDto);
    }
  
    public static Seller getSellerThree(){
        Seller seller = new Seller();
        seller.setId(3);
        seller.setName("Juan");
        seller.setFollowers(List.of(
                new User(1,"Martin",null),
                new User(2,"Ana",null),
                new User(3,"Camila",null)
        ));
        return seller;
    }

    public static List<UserDTO> getSortedListAsc(){
        return List.of(
                new UserDTO(2,"Ana"),
                new UserDTO(3,"Camila"),
                new UserDTO(1,"Martin")
        );
    }

    public static List<UserDTO> getSortedListDesc(){
        return List.of(
                new UserDTO(1,"Martin"),
                new UserDTO(3,"Camila"),
                new UserDTO(2,"Ana")
        );
    }

    public static User getUserTwo(){
        User user = new User();
        user.setId(2);
        user.setName("Carlos");
        user.setFollowing(List.of(
                new Seller(1, "Martin", null,null, null),
                new Seller(2, "Ana", null,null, null),
                new Seller(3, "Camila", null,null, null)
        ));
        return user;
    }

        

}
