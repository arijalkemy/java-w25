package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Product;
import com.example.bootcampsprint1g6.entity.Seller;

import java.time.LocalDate;

public class PostTestGenerator {

    static Integer postId = 0;
    static public Post getPostFromUserProductDate(Seller user, Product product, LocalDate date){
        return new Post(user,postId++, date,product,123,23.4);
    }

    public static PostRequestDTO getPostRequestDTO() {
        return PostRequestDTO.builder()
                .userId(1)
                .date("28-02-2024")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
    }

    public static PostRequestDTO getPostRequestDTO(Integer userId, String date) {
        return PostRequestDTO.builder()
                .userId(userId)
                .date(date)
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
    }

    public static PostResponseDTO getPostResponseDTO(PostRequestDTO requestDTO, Integer postId) {
        return PostResponseDTO.builder()
                .postId(postId)
                .userId(requestDTO.getUserId())
                .date(requestDTO.getDate())
                .product(ProductDTO.builder()
                        .productId(requestDTO.getProduct().getProductId())
                        .productName(requestDTO.getProduct().getProductName())
                        .type(requestDTO.getProduct().getType())
                        .brand(requestDTO.getProduct().getBrand())
                        .color(requestDTO.getProduct().getColor())
                        .build()
                )
                .category(requestDTO.getCategory())
                .price(requestDTO.getPrice())
                .build();
    }


}
