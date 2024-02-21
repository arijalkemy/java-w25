package org.bootcamp.javazoo.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.javazoo.dto.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoDto {

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

    @NotNull
    @NotBlank
    private String has_promo;

    @NotNull
    @Min(0)
    @Max(1)
    private double discount;

}
