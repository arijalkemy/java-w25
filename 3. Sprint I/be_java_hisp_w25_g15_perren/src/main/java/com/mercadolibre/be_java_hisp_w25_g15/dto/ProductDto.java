package com.mercadolibre.be_java_hisp_w25_g15.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDto(
        @Positive(message = "The product_id must be a positive integer") @NotNull(message = "The product_id cannot be null") int product_id,
        @NotNull(message = "The product_name cannot be null") String product_name,
        @NotNull(message = "The type cannot be null") String type,
        @NotNull(message = "The brand cannot be null") String brand,
        @NotNull(message = "The color cannot be null") String color,
        @NotNull(message = "The notes cannot be null") String notes
) {
}
