package com.bootcamp.be_java_hisp_w25_g02.util;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    public static UserFollowingDTO getCorrectAscUserFollowingDTO() {
        return new UserFollowingDTO(1, "Javier",
                List.of(new UserDTO(9, "Malena"), new UserDTO(7, "Maria")));
    }

    public static UserFollowingDTO getCorrectDescUserFollowingDTO() {
        return new UserFollowingDTO(1, "Javier",
                List.of(new UserDTO(7, "Maria"), new UserDTO(9, "Malena")));
    }

    public static User getUserWithFollowingSellers() {
        return new User(1, "Javier", false, new ArrayList<>(List.of(7, 9)), new ArrayList<>());
    }

    public static User followingUserId7() {
        return new User(7, "Maria", true, new ArrayList<>(), new ArrayList<>());
    }

    public static User followingUserId9() {
        return new User(9, "Malena", true, new ArrayList<>(), new ArrayList<>());
    }

    public static User getUserSeller() {
        return new User(10, "JoseMaria", true, new ArrayList<>(), new ArrayList<>(
                List.of()
        ));
    }

    public static User getUserNotSeller() {
        return new User(3, "Martin", false, new ArrayList<>(), new ArrayList<>());
    }

    public static List<Post> getPostsDisordered() {
        return List.of(
                new Post(
                        1,
                        1,
                        LocalDate.now().minusDays(1),
                        new Product(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new Post(
                        3,
                        1,
                        LocalDate.now().minusDays(2),
                        new Product(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),

                new Post(
                        2,
                        1,
                        LocalDate.now(),
                        new Product(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0

                )
        );
    }

    public static List<PostDTO> getPostsDTODisordered() {
        return List.of(
                new PostDTO(
                        1,
                        LocalDate.now().minusDays(1),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new PostDTO(
                        1,
                        LocalDate.now().minusDays(2),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),

                new PostDTO(
                        1,
                        LocalDate.now(),
                        new ProductDTO(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0

                )
        );
    }


    public static List<PostDTO> getPostsDTOOrderByDateAsc() {
        return List.of(
                new PostDTO(
                        1,
                        LocalDate.now().minusDays(2),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0
                ),
                new PostDTO(
                        1,
                        LocalDate.now().minusDays(1),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new PostDTO(
                        1,
                        LocalDate.now(),
                        new ProductDTO(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0
                )
        );
    }
    public static List<PostDTO> getPostsDTOOrderByDateAsc(Integer userSellerId) {
        return List.of(
                new PostDTO(
                        userSellerId,
                        LocalDate.now().minusDays(2),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0
                ),
                new PostDTO(
                        userSellerId,
                        LocalDate.now().minusDays(1),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new PostDTO(
                        userSellerId,
                        LocalDate.now(),
                        new ProductDTO(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0
                )
        );
    }
    public static List<PostDTO> getPostsDTOOrderByDateDesc() {
        return List.of(

                new PostDTO(
                        1,
                        LocalDate.now(),
                        new ProductDTO(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0
                ),
                new PostDTO(
                        1,
                        LocalDate.now().minusDays(1),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new PostDTO(
                        1,
                        LocalDate.now().minusDays(2),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0
                )
        );
    }
    public static List<PostDTO> getPostsDTOOrderByDateDesc(Integer userID) {
        return List.of(

                new PostDTO(
                        userID,
                        LocalDate.now(),
                        new ProductDTO(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0
                ),
                new PostDTO(
                        userID,
                        LocalDate.now().minusDays(1),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new PostDTO(
                        userID,
                        LocalDate.now().minusDays(2),
                        new ProductDTO(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0
                )
        );
    }

    public static FollowingPostDTO getFollowingPostOrderAsc() {
        return new FollowingPostDTO(
                3,
                getPostsDTOOrderByDateAsc()
        );
    }

    public static FollowingPostDTO getFollowingPostOrderDesc() {
        return new FollowingPostDTO(
                3,
                getPostsDTOOrderByDateDesc()
        );
    }

    public static FollowingPostDTO getFollowingPostDisordered() {
        return new FollowingPostDTO(
                3,
                getPostsDTODisordered()
        );
    }

    public static List<Post> getPostsOfLimitTwoWeeks() {
        return List.of(
                new Post(
                        1,
                        1,
                        LocalDate.now().minusWeeks(2),
                        new Product(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new Post(
                        3,
                        1,
                        LocalDate.now().minusWeeks(2).plusDays(1),
                        new Product(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),

                new Post(
                        2,
                        1,
                        LocalDate.now().minusWeeks(2).minusDays(1),
                        new Product(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0

                )
        );
    }

    public static User getUserWithoutFollowed(){
        return new User(
                0,
                "Juan Seguidor",
                false,
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
    public static User getUserToFollow(){
        return new User(
                0,
                "Juan Vendedor",
                true,
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
    public static List<Post> getPostsOfUserDisordered(Integer userId){
        return List.of(
                new Post(
                        0,
                        userId,
                        LocalDate.now().minusDays(1),
                        new Product(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),
                new Post(
                        0,
                        userId,
                        LocalDate.now().minusDays(2),
                        new Product(
                                1,
                                "Prod1",
                                "tipo1",
                                "brand1",
                                "color1",
                                "notes"
                        ),
                        12,
                        10.0

                ),

                new Post(
                        0,
                        userId,
                        LocalDate.now(),
                        new Product(
                                2,
                                "Prod2",
                                "tipo2",
                                "brand2",
                                "color2",
                                "notes"
                        ),
                        11,
                        11.0

                )
        );
    }

    public static User createUser1() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(6, 7, 10);
        return new User(5, "Matias Del Salvador", true, list1, list2);
    }

    public static User createUser2() {
        List<Integer> list3 = List.of(1, 2, 3);
        List<Integer> list4 = List.of(5, 7, 10);
        return new User(6, "Romina Fuentes", true, list3, list4);
    }

    public static User createUser3() {
        List<Integer> list5 = List.of(1, 2, 3);
        List<Integer> list6 = List.of(5, 6, 10);
        return new User(7, "Abel Gomez", true, list5, list6);
    }

    public static User createUser4() {
        List<Integer> list8 = List.of(5, 6, 7);
        List<Integer> list9 = List.of(5, 6, 7);
        return new User(12, "Jorge Alba", true, list8, list9);
    }

    public static List<UserDTO> createFollowerDTOList(String order) {

        List<UserDTO> listOfUserDTOs = new ArrayList<>();

        User user1 = createUser1();
        User user2 = createUser2();
        User user3 = createUser3();

        UserDTO userDTO1 = new UserDTO(user1.getUserId(), user1.getUserName());
        UserDTO userDTO2 = new UserDTO(user2.getUserId(), user2.getUserName());
        UserDTO userDTO3 = new UserDTO(user3.getUserId(), user3.getUserName());

        if (order != null) {
            switch (order) {
                case "name_asc":
                    listOfUserDTOs.add(userDTO3);
                    listOfUserDTOs.add(userDTO1);
                    listOfUserDTOs.add(userDTO2);
                    break;
                case "name_desc":
                    listOfUserDTOs.add(userDTO2);
                    listOfUserDTOs.add(userDTO1);
                    listOfUserDTOs.add(userDTO3);
                    break;
                default:
                    listOfUserDTOs.add(userDTO1);
                    listOfUserDTOs.add(userDTO2);
                    listOfUserDTOs.add(userDTO3);
            }
        } else {
            listOfUserDTOs.add(userDTO1);
            listOfUserDTOs.add(userDTO2);
            listOfUserDTOs.add(userDTO3);
        }


        return listOfUserDTOs;
    }
    public static PostDTO getPostWithUserID(Integer userId){
            return new PostDTO(
                    userId,
                    LocalDate.now(),
                    new ProductDTO(
                            1234572187,
                            "Prod1",
                            "tipo1",
                            "brand1",
                            "color1",
                            "notes"
                    ),
                    12,
                    10.0

            );
    }
    public static PostDTO getPostWithUserID(Integer userId, Integer productId){
        return new PostDTO(
                userId,
                LocalDate.now(),
                new ProductDTO(
                        productId,
                        "Prod1",
                        "tipo1",
                        "brand1",
                        "color1",
                        "notes"
                ),
                12,
                10.0

        );
    }

}
