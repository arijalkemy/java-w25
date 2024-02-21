package com.mercadolibre.be_java_hisp_w25_g15.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record PostDto (
        @NotNull(message = "the user id cannot be null")
        @Positive(message = "The user_id must be a positive integer")
        Integer user_id,
        @NotNull(message = "The date cannot be null")
        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(19|20)\\d{2}|\\d{4}$", message = "The date format must be dd-MM-yyyy")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        String date,
        @Valid @NotNull(message = "The product cannot be null")
        ProductDto product,
        @NotNull(message = "The category cannot be null")
        @Positive(message = "The category must be a positive integer")
        Integer category,
        @NotNull(message = "The price cannot be null")
        @Positive(message = "The price must be a positive number")
        Double price,
        @NotNull(message = "The has_promo cannot be null")
        Boolean has_promo,
        @NotNull(message = "The discount cannot be null")
        Double discount
){
}
