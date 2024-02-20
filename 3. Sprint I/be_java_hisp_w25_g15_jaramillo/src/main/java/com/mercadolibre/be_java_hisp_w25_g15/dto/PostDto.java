package com.mercadolibre.be_java_hisp_w25_g15.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDto (
        @Positive(message = "The user_id must be a positive integer") int user_id,
        @NotNull(message = "The date cannot be null")

        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(19|20)\\d{2}|\\d{4}$", message = "The date format must be dd-MM-yyyy")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        String date,
        @Valid @NotNull(message = "The product cannot be null")
        ProductDto product,
        @Positive(message = "The category must be a positive integer")
        int category,
        @Positive(message = "The price must be a positive number")
        double price
){
}
