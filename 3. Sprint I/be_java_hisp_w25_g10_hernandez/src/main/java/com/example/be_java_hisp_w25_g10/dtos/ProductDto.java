package com.example.be_java_hisp_w25_g10.dtos;

public record ProductDto(int productId,
                         String productName,
                         String type,
                         String brand,
                         String color,
                         String notes,
                         int category,
                         double price
) { }
