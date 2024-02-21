package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("product_id")
    Integer id;
    @JsonProperty("product_name")
    String name;
    String type;
    String brand;
    String color;
    @JsonProperty("notes")
    String notes;

    //ej12
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.type = product.getType();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.notes = product.getNote();
    }
}
