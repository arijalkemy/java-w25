package com.example.be_java_hisp_w25_g01.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    //US 0005
    Integer product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
