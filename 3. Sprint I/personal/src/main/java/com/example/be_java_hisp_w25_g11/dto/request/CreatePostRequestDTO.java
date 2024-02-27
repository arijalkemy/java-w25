package com.example.be_java_hisp_w25_g11.dto.request;

import com.example.be_java_hisp_w25_g11.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequestDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("product")
    private ProductDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private double price;
}
