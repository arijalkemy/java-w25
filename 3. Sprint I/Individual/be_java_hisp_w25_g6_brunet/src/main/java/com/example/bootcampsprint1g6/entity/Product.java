package com.example.bootcampsprint1g6.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    Integer productId;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
