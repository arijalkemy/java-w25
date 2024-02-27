package org.bootcamp.javazoo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
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

    @JsonDeserialize(using = NumberDeserializers.BooleanDeserializer.class)
    private Boolean has_promo;

    @Min(0)
    @Max(1)
    private Double discount;
}
