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
    Boolean hasPromo;
    Double discount;

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price){
        this.postId = -1;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0D;
    }

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price, Double discount) {
        this.postId = -1;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = true;
        this.discount = discount;
    }
}
