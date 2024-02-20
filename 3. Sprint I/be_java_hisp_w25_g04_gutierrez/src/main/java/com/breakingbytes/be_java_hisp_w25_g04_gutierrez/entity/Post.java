package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity;

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
    int userId;
    LocalDate date;
    Product product;
    int category;
    double price;
    double discount;
    boolean hasPromo;

    public Post(int userId, LocalDate date, Product product, int category, double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.discount = 0.0;
        this.hasPromo = false;
    }
}
