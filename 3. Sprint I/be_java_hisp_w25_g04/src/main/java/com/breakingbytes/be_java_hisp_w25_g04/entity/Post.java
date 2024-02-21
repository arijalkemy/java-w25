package com.breakingbytes.be_java_hisp_w25_g04.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    int postId;
    int userId;
    LocalDate date;
    Product product;
    int category;
    double price;
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
