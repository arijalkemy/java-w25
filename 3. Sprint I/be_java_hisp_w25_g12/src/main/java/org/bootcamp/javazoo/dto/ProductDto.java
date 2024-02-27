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
public class ProductDto {
    @NotNull
    @Min(0)
    private Integer product_id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String product_name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String type;

    @NotNull
    @NotBlank
    @NotEmpty
    private String brand;

    @NotNull
    @NotBlank
    @NotEmpty
    private String color;

    @NotNull
    @NotBlank
    @NotEmpty
    private String notes;

}
