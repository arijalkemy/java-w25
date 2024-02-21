package com.example.be_java_hisp_w25_g11.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("color")
    private String color;
    @JsonProperty("notes")
    private String notes;
}
