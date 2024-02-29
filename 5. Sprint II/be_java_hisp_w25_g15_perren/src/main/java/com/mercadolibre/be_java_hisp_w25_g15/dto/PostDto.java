package com.mercadolibre.be_java_hisp_w25_g15.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PostDto (


        /*
        Que el campo no esté vacío.
        Mayor 0
         */
        @NotNull(message = "The user_id cannot be null")
        @Positive(message = "The user_id must be a positive integer") Integer user_id,
        @Nullable Integer post_id,

        /*
        Que el campo no esté vacío.
         */
        @NotNull(message = "The date cannot be null")
        @NotBlank(message = "The product_name cannot be empty")
        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(19|20)\\d{2}|\\d{4}$", message = "The date format must be dd-MM-yyyy")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        String date,
        @Valid @NotNull(message = "The product cannot be null")
        ProductDto product,
        /*
        Que el campo no esté vacío.
         */
        @NotNull(message = "The category cannot be null")
        @Positive(message = "The category must be a positive integer")
        Integer category,
        /*
        Que el campo no esté vacío
El      precio máximo puede ser 10.000.000.
         */
        @NotNull(message = "The price cannot be null")
        @DecimalMax(value = "10000000", message = "The price cannot exceed 10,000,000")
        @Positive(message = "The price must be a positive number")
        Double price
){
}
