package util;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g01.dto.response.FollowersDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.dto.response.UserDTO;
import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.entity.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtilGenerator {

    public static UserDTO getUserDTO(){
        return new UserDTO(1,"martinMarquez");
    }
    public static User getUser() {return new User(1,"martinMarquez", new ArrayList<>(List.of(5)), new ArrayList<>(List.of()), new ArrayList<>(List.of()));}
    public static User getUser2(){return new User(5,"leanSaracco", new ArrayList<>(List.of()), new ArrayList<>(List.of(1,2,3,4)),new ArrayList<>(List.of(4,5)));}
    public static User getUser3(){return new User(3,"marioNeta", new ArrayList<>(List.of()), new ArrayList<>(List.of(1,2,3,4)),new ArrayList<>(List.of(4,5)));}
    public static List<UserDTO> getUserDTOList(){
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(2,"ariJaime"));
        users.add(new UserDTO(3,"ezeEscobar"));
        return users;
    }

    public static List<User> getUserList(){
        User user1 = new User(2,"ariJaime", new ArrayList<>(List.of(4,5)), new ArrayList<>(List.of()), new ArrayList<>(List.of()));
        return new ArrayList<>(List.of(user1));
    }

    public static List<User> getUserList2(){
        List<User> users = new ArrayList<>();
        users.add(new User(5,"leanSaracco",List.of(),List.of(2),List.of()));
        users.add(new User(4,"sofiaMaria",List.of(),List.of(2),List.of()));
        return users;
    }

    public static PostDTO getPostDTO(){
        ProductDTO product = new ProductDTO();
        product.setProduct_id(1);
        product.setProduct_name("Silla Gamer");
        product.setType("Gamer");
        product.setBrand("Racer");

        return new PostDTO(5,1, LocalDate.of(2024,01,02), product, 100, 1500.50);
    }


    public static FollowersDTO getFollowersDTOasc(){
        return FollowersDTO.builder()
                .user_id(4)
                .user_name("sofiaMaria")
                .followers(Arrays.asList(
                        UserDTO.builder().user_id(2).user_name("ariJaime").build(),
                        UserDTO.builder().user_id(3).user_name("ezeEscobar").build()
                ))
                .build();
    }

    public static FollowersDTO getFollowersDTOdesc(){
        return FollowersDTO.builder()
                .user_id(4)
                .user_name("sofiaMaria")
                .followers(Arrays.asList(
                        UserDTO.builder().user_id(3).user_name("ezeEscobar").build(),
                        UserDTO.builder().user_id(2).user_name("ariJaime").build()

                ))
                .build();
    }



    public static PostsListDTO getPostListDTO(){
        List<PostDTO> posts = new ArrayList<>();
        posts.add(new PostDTO(5,2, LocalDate.now().minusDays(2),new ProductDTO(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition"), 100, 1500.00));
        posts.add(new PostDTO(5,2, LocalDate.now().minusDays(10),  new ProductDTO(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition"), 120, 2800.69));

       return new PostsListDTO(1, posts);
    }

    public static List<Post> getPostList(){
        Post post1 = new Post(2, 5, LocalDate.now().minusDays(2),1, 100, 1500.00);
        Post post2 = new Post(2,5,LocalDate.now().minusDays(10),  1, 120, 2800.69);

        return List.of(post1,post2);
    }

    public static Product getProduct(){
        return new Product(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition");
    }
}
