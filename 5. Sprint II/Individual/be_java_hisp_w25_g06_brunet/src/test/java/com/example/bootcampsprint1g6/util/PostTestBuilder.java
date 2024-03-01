package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Product;
import com.example.bootcampsprint1g6.util.mapper.ProductMapper;

public class PostTestBuilder {

    private static final int DEFAULT_USER_ID = 1;
    private static final String DEFAULT_DATE = "17-02-2024";
    private static final int DEFAULT_CATEGORY = 123;
    private static final double DEFAULT_PRICE = 23.4;

    public static PostRequestDTO buildPostRequestDTO() {
        return new PostRequestDTO(DEFAULT_USER_ID, DEFAULT_DATE, buildProductDto(), DEFAULT_CATEGORY, DEFAULT_PRICE);
    }

    public static PostResponseDTO buildPostResponseDTO() {
        return new PostResponseDTO(DEFAULT_USER_ID, 0, DEFAULT_DATE, buildProductDto(), DEFAULT_CATEGORY, DEFAULT_PRICE);
    }

    private static ProductDTO buildProductDto() {
        return ProductMapper.getInstance(
                new Product(23, "camisa a rayas", "indumentaria", "sarkany", "rojo", "unico color, puro algodon")
        );
    }
}