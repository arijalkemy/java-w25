package com.be_java_hisp_w25_g02_zanaboni.dto.response;

public record ProductDTO(
        Integer product_id,
        String product_name,
        String type,
        String brand,
        String color,
        String notes) {
}
