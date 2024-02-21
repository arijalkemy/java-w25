package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    Integer userId;
    Integer postId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    Boolean has_promo;
    Double discount;

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price, Boolean has_promo, Double discount) {
        this.userId = userId;
        this.postId = -1;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public Post(Integer user_id, LocalDate date, Product product, Integer category, Double price){
        this.postId = -1;
        this.userId = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public boolean has_promo() {
        return has_promo;
    }
}
