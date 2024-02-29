package com.breakingbytes.be_java_hisp_w25_g04.utils;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;


import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;


import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FactoryUsers { // llamar a los metodos estaticos

    public static ModelMapper mapper = new ModelMapper();

    public static List<User> getUsers() {
        User pepe = new User();
        pepe.setId(1);
        User carlos = new User();
        carlos.setId(2);
        pepe.setName("Pepe");
        carlos.setName("Carlos");

        Seller juan = new Seller();
        juan.setId(3);
        juan.setName("Juan");
        pepe.addFollowing(juan);
        juan.addFollower(pepe);

        Seller robert = new Seller(); // ID: 4
        robert.setId(4);
        robert.setName("Robert");
        robert.addFollower(carlos);
        carlos.addFollowing(robert);


        Product p1 = new Product(1, "Laptop", "Electronics", "Dell", "Silver", "Thin and lightweight design");
        Product p2 = new Product(2, "AAAAAAAA", "Electronics", "Samsung", "Black", "5G capable");
        Product p3 = new Product(3, "Running Shoes", "Apparel", "Nike", "Blue", "Breathable mesh upper");
        Product p4 = new Product(4, "Headphones", "Electronics", "Sony", "Red", "Noise-canceling feature");
        Product p5 = new Product(5, "Backpack", "Accessories", "JanSport", "Gray", "Multiple compartments");

        Post post1 = new Post(3, LocalDate.of(2024,2,20), p2, 100, 1500.0);
        Post post2 = new Post(3, LocalDate.of(2023, 2,20), p3, 100, 1000.0);
        Post post3 = new Post(4, LocalDate.of(2021,10,19), p1, 200, 240.0);
        Post post4 = new Post(3, LocalDate.of(2019,2,21), p4, 100, 20.0);
        Post post5 = new Post(3, LocalDate.of(2019,2,26), p5, 300, 30.0);

        juan.getPosts().add(post1);
        juan.getPosts().add(post2);
        robert.getPosts().add(post3);
        juan.getPosts().add(post4);
        juan.getPosts().add(post5);

        return new ArrayList<>(List.of(pepe, carlos, juan, robert));
    }

    public static User createUserComplete(Integer id){
        User pepe = new User(); // ID: 1
        pepe.setName("Pepe");
        pepe.setId(id);

        Seller juan = new Seller();
        juan.setId(3);
        juan.setName("Juan");
        pepe.addFollowing(juan);

        Product p1 = new Product(1, "Laptop", "Electronics", "Dell", "Silver", "Thin and lightweight design");
        Product p2 = new Product(2, "AAAAAAAA", "Electronics", "Samsung", "Black", "5G capable");

        Post post1 = new Post(3, LocalDate.now().minusDays(10), p1, 100, 1500.0);
        Post post2 = new Post(3, LocalDate.now().minusDays(4), p2, 100, 1000.0);

        juan.getPosts().add(post1);
        juan.getPosts().add(post2);
        return pepe;
    }

    public static List<Seller> getSellers(){
        User pepe = new User(); // ID: 1
        User carlos = new User(); // ID: 2
        pepe.setName("Pepe");
        carlos.setName("Carlos");

        Seller juan = new Seller(); // ID: 3
        juan.setName("Juan");
        pepe.addFollowing(juan);
        juan.addFollower(pepe);

        Seller robert = new Seller(); // ID: 4
        robert.setName("Robert");
        robert.addFollower(carlos);
        carlos.addFollowing(robert);


        Product p1 = new Product(1, "Laptop", "Electronics", "Dell", "Silver", "Thin and lightweight design");
        Product p2 = new Product(2, "AAAAAAAA", "Electronics", "Samsung", "Black", "5G capable");
        Product p3 = new Product(3, "Running Shoes", "Apparel", "Nike", "Blue", "Breathable mesh upper");
        Product p4 = new Product(4, "Headphones", "Electronics", "Sony", "Red", "Noise-canceling feature");
        Product p5 = new Product(5, "Backpack", "Accessories", "JanSport", "Gray", "Multiple compartments");

        Post post1 = new Post(3, LocalDate.of(2024,2,20), p2, 100, 1500.0);
        Post post2 = new Post(3, LocalDate.of(2023, 2,20), p3, 100, 1000.0);
        Post post3 = new Post(4, LocalDate.of(2021,10,19), p1, 200, 240.0);
        Post post4 = new Post(3, LocalDate.of(2019,2,21), p4, 100, 20.0);
        Post post5 = new Post(3, LocalDate.of(2019,2,26), p5, 300, 30.0);

        juan.getPosts().add(post1);
        juan.getPosts().add(post2);
        robert.getPosts().add(post3);
        juan.getPosts().add(post4);
        juan.getPosts().add(post5);

        return new ArrayList<>(List.of(juan, robert));
    }



    public static Seller createSeller(Integer id){
        Seller seller = new Seller();
        seller.setId(id);
        seller.setName("Matias");
        return seller;
    }
    public static User createUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setName("Gabriel");
        return user;
    }

    public static List<Post> getPostsDateDesc(){
        return getPostsWithoutOrder().stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
    }

    public static List<Post> getPostsWithoutOrder(){
        Post p1 = new Post(3, LocalDate.now().minusWeeks(1),
                new Product(1, "Laptop", "Electronics", "Dell", "Silver", "Thin and lightweight design"),
                100, 1500.0);
        p1.setPostId(2);
        Post p2 = new Post(3, LocalDate.now(),
                new Product(2, "Camera", "Electronics", "Samsung", "Black", "5G capable"),
                100, 1500.0);
        p2.setPostId(3);
        Post p3 = new Post(3, LocalDate.now().minusDays(5),
                new Product(3, "Running Shoes", "Apparel", "Nike", "Blue", "Breathable mesh upper"),
                100, 1500.0);
        p3.setPostId(1);
        return new ArrayList<>(List.of(p1,p2,p3));
    }

    public static List<Post> getPostsDateAsc(){
        return getPostsWithoutOrder().stream().sorted(Comparator.comparing(Post::getDate)).toList();
    }

    public static List<ResponsePostDTO> convertPostToResponsePostDTO(List<Post> posts){
        return posts.stream().map(p ->
                new ResponsePostDTO(p.getUserId(),
                        p.getPostId(),
                        p.getDate(),
                        p.getProduct(),
                        p.getCategory(),
                        p.getPrice())).toList();
    }

    public static LastPostsDTO generateLastPostDto(User user) {
        User pepe = user;
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

    public static User getUserOne() {
        User user = new User();
        user.setId(1);
        user.setName("Pepe");
        user.setFollowing(List.of(
                new Seller(3, "Juan", null,null, null)
        ));
        return user;
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

    public static Seller getSellerFour(){
        Seller seller = new Seller();
        seller.setId(4);
        seller.setName("Robert");
        seller.setFollowers(List.of(
                new User(1,"Pepe",null)
        ));
        return seller;
    }
        

}
