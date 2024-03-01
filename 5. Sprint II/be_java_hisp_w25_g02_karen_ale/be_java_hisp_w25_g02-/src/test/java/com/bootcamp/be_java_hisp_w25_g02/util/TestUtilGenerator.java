package com.bootcamp.be_java_hisp_w25_g02.util;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;

import java.util.ArrayList;

import java.time.LocalDate;
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
                return new User(1, "Javier", false, new ArrayList<>(List.of(
                        7, 9
                )), new ArrayList<>());
        }

        public static User followingUserId7() {
                return new User(7, "Maria", true, new ArrayList<>(), new ArrayList<>());
        }

        public static User followingUserId9() {
                return new User(9, "Malena", true, new ArrayList<>(), new ArrayList<>());
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
    public static FollowingPostDTO getFollowingPostDisordered(){
        return new FollowingPostDTO(
                3,
                getPostsDTODisordered()
        );
    }
    public static List<Post> getPostsOfLimitTwoWeeks(){
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

}
