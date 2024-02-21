package com.example.bootcampsprint1g6.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    @JsonProperty("product_id")
    Integer productId;

    @JsonProperty("product_name")
    String productName;

    String type;

    String brand;

    String color;

    String notes;
}
