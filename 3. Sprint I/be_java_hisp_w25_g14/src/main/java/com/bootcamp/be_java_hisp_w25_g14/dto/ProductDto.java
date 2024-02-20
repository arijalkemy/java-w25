package com.bootcamp.be_java_hisp_w25_g14.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

     Integer product_id;
     String product_name;
     String type;
     String brand;
     String color;
     String notes;


}
