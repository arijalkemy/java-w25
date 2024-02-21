package com.example.bootcampsprint1g6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Seller seller;
    Integer postId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;

    public Post(Seller seller, LocalDate date, Product product, Integer category, Double price) {
        this.seller = seller;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

}
