package com.example.be_java_hisp_w25_g11.dto;

import com.example.be_java_hisp_w25_g11.dto.request.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerPostDTO {
    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "Id debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "Id debe ser mayor a cero")
    @JsonProperty("post_id")
    private Integer postId;

    @NotBlank(message = "La fecha no puede estar vacía.")
    @JsonProperty("date")
    private String date;
    @Valid
    @JsonProperty("product")
    private ProductDTO product;

    @NotNull(message = "La categoria no puede estar vacía")
    @JsonProperty("category")
    private Integer category;

    @NotNull(message = "El precio no puede estar vacío")
    @DecimalMax(value = "10000000.00" ,message = "El precio máximo por producto es de 10.000.000")
    @JsonProperty("price")
    private Double price;
}
