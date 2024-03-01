package com.example.be_java_hisp_w25_g10.utils;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.entities.RolEnum;
import com.example.be_java_hisp_w25_g10.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Builder {
    public static User[] VerifyCountTestBuilder() {
        return new User[]{
                new User(1, "user1", "lastName", RolEnum.SELLER),
                new User(3, "user3", "lastName", RolEnum.BUYER),
        };
    }

    public static List<Post> testSortExistBuilder() {
        return new ArrayList<>(Arrays.asList(new Post[]{
                new Post(1,
                        new User(1, "user1", "lastName", RolEnum.SELLER),
                        LocalDate.now(),
                        new Product(1,
                                123,
                                29.99,
                                "Producto1",
                                "Electrónico",
                                "MarcaA",
                                "Rojo",
                                "Notas sobre el producto"
                        )
                ),
                new Post(2,
                        new User(1, "user1", "lastName", RolEnum.SELLER),
                        LocalDate.now().minusDays(19),
                        new Product(1,
                                123,
                                29.99,
                                "Producto2",
                                "Tecnología",
                                "MarcaB",
                                "Amarillo",
                                "Notas sobre el producto"
                        )
                )
        }));
    }

    //Ordered List in a Desc way
    public static PostsDto orderedListPostDesc() {
        LocalDate today = LocalDate.now();
        PostsDto orderDescList = new PostsDto(
                3,
                List.of(
                        new PostDto(
                                3,
                                1,
                                today.plusDays(1),
                                new ProductDto(1,
                                        "Producto1",
                                        "Electrónico",
                                        "MarcaA",
                                        "Rojo",
                                        "Notas sobre el producto",
                                        123,
                                        29.99)

                        ),
                        new PostDto(
                                3,
                                1,
                                today,
                                new ProductDto(1,
                                        "Producto1",
                                        "Electrónico",
                                        "MarcaA",
                                        "Rojo",
                                        "Notas sobre el producto",
                                        123,
                                        29.99)

                        ),
                        new PostDto(
                                3,
                                1,
                                today.minusDays(1),
                                new ProductDto(1,
                                        "Producto1",
                                        "Electrónico",
                                        "MarcaA",
                                        "Rojo",
                                        "Notas sobre el producto",
                                        123,
                                        29.99)

                        )
                )
        );
        return orderDescList;
    }

    //Ordered List in an Asc way
    public static PostsDto orderedListPostAsc () {
        LocalDate today = LocalDate.now();
        PostsDto orderAscList = new PostsDto(3,
                List.of(
                    new PostDto(
                            3,
                            1,
                            today.minusDays(1),
                            new ProductDto(1,
                                    "Producto1",
                                    "Electrónico",
                                    "MarcaA",
                                    "Rojo",
                                    "Notas sobre el producto",
                                    123,
                                    29.99)
                    ),
                    new PostDto(
                            3,
                            1,
                            today,
                            new ProductDto(1,
                                    "Producto1",
                                    "Electrónico",
                                    "MarcaA",
                                    "Rojo",
                                    "Notas sobre el producto",
                                    123,
                                    29.99)
                    ),
                    new PostDto(
                            3,
                            1,
                            today.plusDays(1),
                            new ProductDto(1,
                                    "Producto1",
                                    "Electrónico",
                                    "MarcaA",
                                    "Rojo",
                                    "Notas sobre el producto",
                                    123,
                                    29.99)
                    )
                )
        );
        return orderAscList;
    }
//Posts ready to be ordered
    public static List<Post> postNotInOrder () {
        LocalDate today = LocalDate.now();
        List<Post> posts = new ArrayList<>(Arrays.asList(new Post[]{
                new Post(1,
                        new User(3, "user3", "lastName", RolEnum.BUYER),
                        today.minusDays(1),
                        new Product(1,
                                123,
                                29.99,
                                "Producto1",
                                "Electrónico",
                                "MarcaA",
                                "Rojo",
                                "Notas sobre el producto"
                        )
                ),
                new Post(1,
                        new User(3, "user3", "lastName", RolEnum.BUYER),
                        today.plusDays(1),
                        new Product(1,
                                123,
                                29.99,
                                "Producto1",
                                "Electrónico",
                                "MarcaA",
                                "Rojo",
                                "Notas sobre el producto"
                        )
                ),
                new Post(1,
                        new User(3, "user3", "lastName", RolEnum.BUYER),
                        today,
                        new Product(1,
                                123,
                                29.99,
                                "Producto1",
                                "Electrónico",
                                "MarcaA",
                                "Rojo",
                                "Notas sobre el producto"
                        )
                )

        }));
        return posts;
    }

    public static final List<Post> postsExpected = List.of(
            new Post(
                    1,
                    new User(1, "Martin", "Ushima", RolEnum.SELLER),
                    LocalDate.now().minusDays(19),
                    new Product(1,
                            123,
                            29.99,
                            "Producto3",
                            "Hogar",
                            "MarcaC",
                            "Azul",
                            "Notas sobre el producto")
            ),
            new Post(
                    1,
                    new User(1, "Camilo", "Jaramillo", RolEnum.SELLER),
                    LocalDate.now().minusDays(17),
                    new Product(1,
                            123,
                            29.99,
                            "Producto3",
                            "Hogar",
                            "MarcaC",
                            "Azul",
                            "Notas sobre el producto"
                    )
            )
    );

    public static final PostCreatedDto postToCreate = new PostCreatedDto(
            1,
            "10-03-2024",
            new Product(
                    1,
                    1,
                    10,
                    "Aire acondicionado",
                    "Electrodomestico",
                    "Samsung",
                    "Gris",
                    "Aire acondicionado ultima generación"
            ),
            1,
            10
    );

    public static final PostCreatedDto postToCreateInvalidDate = new PostCreatedDto(
            1,
            "",
            new Product(
                    1,
                    1,
                    10,
                    "Aire acondicionado",
                    "Electrodomestico",
                    "Samsung",
                    "Gris",
                    "Aire acondicionado ultima generación"
            ),
            1,
            10
    );

}
