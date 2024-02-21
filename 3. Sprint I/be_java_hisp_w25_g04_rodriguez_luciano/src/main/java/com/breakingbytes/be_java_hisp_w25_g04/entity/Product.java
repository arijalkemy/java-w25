package com.breakingbytes.be_java_hisp_w25_g04.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @JsonProperty("product_id")
    int id;
    static int count = 1;
    @JsonProperty("product_name")
    String name;
    String type;
    String brand;
    String color;
    String notes;

    public Product(){
        this.id = count;
        count++;
    }

    public Product(String name, String type, String brand, String color, String notes) {
        super();
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
