package org.bootcamp.javazoo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    private boolean has_promo = false;

    private Double discount = 0.0;

}
