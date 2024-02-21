package com.breakingbytes.be_java_hisp_w25_g04.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    int userId;
    LocalDate date;
    Product product;
    int category;
    double price;
    boolean has_promo = false;
    double discount;
    static int count = 1;
    Seller seller;


    public Post(){
        this.userId = count;
        count++;
    }
    public Post(LocalDate date, Product product, int category, double price) {
        super();
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
    public Post(LocalDate date, Product product, int category, double price, double discount) {
        super();
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }
}
