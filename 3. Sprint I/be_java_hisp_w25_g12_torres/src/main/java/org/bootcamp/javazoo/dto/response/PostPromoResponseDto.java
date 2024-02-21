package org.bootcamp.javazoo.dto.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcamp.javazoo.dto.ProductDto;
@AllArgsConstructor
@Data
public class PostPromoResponseDto {
    @NotNull
    @Min(0)
    private Integer user_id;

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

    private boolean has_promo;

    @NotNull
    @Min(0)
    private double discount;
}
