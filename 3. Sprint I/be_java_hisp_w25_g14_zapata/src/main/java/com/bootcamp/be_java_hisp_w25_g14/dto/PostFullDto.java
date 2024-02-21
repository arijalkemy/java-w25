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
public class PostFullDto {
    Integer post_id;
    Integer user_id;
    String date;
    ProductDto product;
    Boolean isOnDiscount;
    String discountUntil;
    Integer category;
    Double price;
    Double discountPrice;

}
