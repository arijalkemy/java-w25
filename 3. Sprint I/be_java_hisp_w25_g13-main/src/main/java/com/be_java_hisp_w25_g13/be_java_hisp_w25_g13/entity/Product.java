package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    Integer productId;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
