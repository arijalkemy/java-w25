package org.bootcamp.javazoo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    @NotNull (message = "The 'id' cannot be empty.") @Positive (message = "The 'id' must be greater than zero")
    private Integer user_id;

    @NotEmpty (message = "The 'date' cannot be empty.")
    private String date;

    @NotNull (message = "The 'product' cannot be empty.")
    @Valid
    private ProductDto product;

    @NotNull (message = "The 'category' cannot be empty.")
    private Integer category;

    @NotNull (message = "The 'price' cannot be empty.")
    @Min(value = 0, message = "The 'price' must be greater than zero")
    @Max(value = 10000000, message = "The maximum price per product must be 10,000,000")
    private Double price;
}
