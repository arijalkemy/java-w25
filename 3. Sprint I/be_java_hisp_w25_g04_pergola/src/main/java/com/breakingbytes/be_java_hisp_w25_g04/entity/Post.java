package com.breakingbytes.be_java_hisp_w25_g04.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Post {
    int postId;
    int userId;
    LocalDate date;
    Product product;
    int category;
    double price;
    boolean has_promo;
    double discount;
    static int count = 1;

    public Post() {
        this.postId = count;
        count++;
    }

    public Post(int userId, LocalDate date, Product product, int category, double price) {
        this.postId = count;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        count++;
    }
}
