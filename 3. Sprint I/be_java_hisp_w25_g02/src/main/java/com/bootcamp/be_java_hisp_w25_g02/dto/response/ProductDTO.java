package com.bootcamp.be_java_hisp_w25_g02.dto.response;

public record ProductDTO(
        Integer product_id,
        String product_name,
        String type,
        String brand,
        String color,
        String notes
) {}
