package org.bootcamp.javazoo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponseDto {
    @NotNull
    @Min(0)
    private Integer user_id;

    @NotNull
    @Min(0)
    private Integer post_id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String date;

    @NotNull
    private ProductDto product;

    @NotNull
    private Integer category;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @NotBlank
    private String has_promo;

    @NotNull
    @Min(0)
    @Max(1)
    private double discount;

}
