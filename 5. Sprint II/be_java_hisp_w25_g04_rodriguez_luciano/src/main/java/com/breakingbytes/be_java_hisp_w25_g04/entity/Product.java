package com.breakingbytes.be_java_hisp_w25_g04.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @JsonProperty("product_id")
    Integer id;
    @JsonProperty("product_name")
    String name;
    String type;
    String brand;
    String color;
    String notes;

}
