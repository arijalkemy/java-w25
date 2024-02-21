package com.social.meli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @JsonProperty("product_id")
    Integer id;
    @JsonProperty("product_name")
    String name;
    String type;
    String color;
    String brand;
    @JsonProperty("notes")
    String note;
}
