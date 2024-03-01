package com.example.bootcampsprint1g6.util.builder;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Product;
import com.example.bootcampsprint1g6.util.mapper.ProductMapper;

public class Mockbuilder {

    public static PostRequestDTO buildPostRequestDTO(String date, Integer userId) {
        return new PostRequestDTO(
                userId,
                date,
                buildProductDto(),
                123,
                23.4
        );
    }
    public static PostResponseDTO buildPostResponseDTO() {
        return new PostResponseDTO(1, 0, "17-02-2024", buildProductDto(), 123, 23.4);
    }

    private static ProductDTO buildProductDto(){
        return ProductMapper.getInstance(new Product(23,
                "camisa a rayas",
                "indumentaria",
                "sarkany",
                "rojo",
                "unico color, puro algodon"));
    }
    public static PostRequestDTO buildWrongPostRequestDTO() {
        return new PostRequestDTO(
                1,
                null,
                buildProductDto(),
                123,
                23.4
        );
    }
    public static PostRequestDTO buildPostNoProductRequestDTO() {
        return new PostRequestDTO(
                1,
                "12-04-2023",
                null,
                123,
                23.4
        );
    }
}
