package com.example.be_java_hisp_w25_g01.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer post_id;
    Integer user_id;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    Boolean has_promo;
    Double discount;

    public Post(Integer post_id, Integer user_id, LocalDate date, Product product, Integer category, Double price) {
        this(post_id, user_id, date, product, category, price, false, 0D);
    }
}
