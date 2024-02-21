package com.bootcamp.be_java_hisp_w25_g14_Lozano.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer postId;
    Integer userId;
    String date;
    Product product;
    Integer category;
    Double price;
    Boolean hasPromo = false;
    Double discount = 0.0;

}
