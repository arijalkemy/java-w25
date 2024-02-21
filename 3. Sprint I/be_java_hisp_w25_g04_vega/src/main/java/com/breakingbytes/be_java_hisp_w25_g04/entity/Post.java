package com.breakingbytes.be_java_hisp_w25_g04.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Post {
    public static int count = 1;

    int userId;
    int postId;
    LocalDate date;
    Product product;
    int category;
    double price;
    boolean hasPromo;
    double discount; //in decimal like 0.25

    public Post() {
        this.postId = count;
        count++;
    }

    public Post(int userId, LocalDate date, Product product, int category, double price) {
        this.userId = userId;
        this.postId = count;
        count++;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0;
    }
}
