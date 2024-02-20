package com.example.be_java_hisp_w25_g01_manzano.entity;

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
    boolean has_promo;
    Double discount;

    public Post(Integer post_id, Integer user_id, LocalDate date, Product product, Integer category, Double price) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}







