package org.socialmeli.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer postId;
    Integer userId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    Boolean hasPromo;
    Double discount;
    public static Integer postIdCounter = 0;

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
