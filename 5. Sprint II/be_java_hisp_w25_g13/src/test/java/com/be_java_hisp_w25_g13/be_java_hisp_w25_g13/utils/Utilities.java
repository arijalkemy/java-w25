package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilities {
    public static UserDTO generateUserDTO(Integer id, String name){
        return new UserDTO(id,name);
    }
    public static List<UserDTO> generateUsersDTO(){
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(generateUserDTO(1,"Juan Manuel"));
        userDTOS.add(generateUserDTO(2,"Julian"));
        userDTOS.add(generateUserDTO(3,"Felipe"));
        return userDTOS;
    }
    public static Seller generateSeller(Integer id, String name, List<User> followers){
        return new Seller(id,name,followers);
    }
    public static User generateUser(Integer id, String name){
        return new User(id,name);
    }

    public static List<User> generateListUsers() {
        List<User> users = new ArrayList<>();
        users.add(generateUser(4,"Daniela"));
        users.add(generateUser(5,"Sebastian"));
        users.add(generateUser(6,"Manuel"));
        return users;
    }
    public static List<UserDTO> generateListUserToUsersDtoAsc() {
        List<UserDTO> users = new ArrayList<>();
        users.add(generateUserDTO(4,"Daniela"));
        users.add(generateUserDTO(6,"Manuel"));
        users.add(generateUserDTO(5,"Sebastian"));
        return users;
    }
    public static List<UserDTO> generateListUserToUsersDtoDesc() {
        List<UserDTO> users = new ArrayList<>();
        users.add(generateUserDTO(5,"Sebastian"));
        users.add(generateUserDTO(6,"Manuel"));
        users.add(generateUserDTO(4,"Daniela"));
        return users;
    }
    public static List<Seller>  generateListSellers(){
        List<Seller> sellers = new ArrayList<>();
        sellers.add(generateSeller(1, "Juan Manuel", Collections.emptyList()));
        sellers.add(generateSeller(2, "Julian", Collections.emptyList()));
        sellers.add(generateSeller(3, "Felipe", Collections.emptyList()));
        return sellers;
    }
    public static List<UserDTO>  generateListSellerToUserDtoAsc(){
        List<UserDTO> sellers = new ArrayList<>();
        sellers.add(generateUserDTO(3, "Felipe"));
        sellers.add(generateUserDTO(1, "Juan Manuel"));
        sellers.add(generateUserDTO(2, "Julian"));
        return sellers;
    }
    public static List<UserDTO>  generateListSellerToUserDtoDesc(){
        List<UserDTO> sellers = new ArrayList<>();
        sellers.add(generateUserDTO(2, "Julian"));
        sellers.add(generateUserDTO(1, "Juan Manuel"));
        sellers.add(generateUserDTO(3, "Felipe"));
        return sellers;
    }
    public static Seller generateSeller3Followed(Integer id, String name){
        return new Seller(id, name, generateListUsers());
    }
    public static User generateUser3Following(Integer id, String name){
        return new User(id, name, generateListSellers());
    }
    public static Product generateProduct(Integer id, String name){
        return new Product(id, name, "Comida", "Carulla", "Verde", "Expira en 3 dias");
    }

    public static ProductDTO generateProductDto(Integer id, String name){
        return new ProductDTO(id, name, "Comida", "Carulla", "Verde", "Expira en 3 dias");
    }
    public static String serializeUserDTO(UserDTO userDTO) throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(userDTO);
    }
    public static Post generatePost(Integer userId, Integer postId, LocalDate date, Integer productId, String productName){
        return new Post(userId, date, generateProduct(productId, productName), 0, 10.0);
    }

    public static PostDTO generatePostDto(Integer userId, Integer postId, LocalDate date, Integer productId, String productName){
        return new PostDTO(userId, date, generateProductDto(productId, productName), 0, 10.0);
    }

    public static List<Product> generateListProducts(){
        return List.of(
                generateProduct(1, "arepa"),
                generateProduct(2, "papa"),
                generateProduct(3, "arequipe")
        );
    }

    public static List<ProductDTO> generateListProductsDto(){
        return List.of(
                generateProductDto(1, "arepa"),
                generateProductDto(2, "papa"),
                generateProductDto(3, "arequipe")
        );
    }
    public static List<Post> generateListPost(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        LocalDate date = LocalDate.parse("2024-2-25", formatter);
        List<Post> listPost = new ArrayList<>();
        listPost.add(generatePost(2,5, date,6,"Laptop"));
        listPost.add(generatePost(2,6, date,7,"Impresora"));
        listPost.add(generatePost(2,7, date,8,"Monitor"));
        return listPost;
    }

    public static FollowersDTO generateFollowersDTOAsc(Integer sellerId, String name){
        return new FollowersDTO(
                sellerId,
                name,
                generateListUserToUsersDtoAsc()
        );
    }

    public static FollowersDTO generateFollowersDTODesc(Integer sellerId, String name){
        return new FollowersDTO(
                sellerId,
                name,
                generateListUserToUsersDtoDesc()
        );
    }
    public static FollowedDTO generateFollowedDTOAsc(Integer sellerId, String name){
        return new FollowedDTO(
                sellerId,
                name,
                generateListSellerToUserDtoAsc()
        );
    }
    public static FollowedDTO generateFollowedDTODesc(Integer sellerId, String name){
        return new FollowedDTO(
                sellerId,
                name,
                generateListSellerToUserDtoDesc()
        );
    }
}
