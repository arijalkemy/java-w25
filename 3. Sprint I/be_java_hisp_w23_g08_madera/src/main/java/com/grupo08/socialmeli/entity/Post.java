package com.grupo08.socialmeli.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer userId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    boolean has_promo;
    double discount;
    
    public Post(Integer userId, String date, Product product, Integer category, Double price, boolean has_promo,
            double discount) {
        this.userId = userId;
        LocalDate datetime = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.date = datetime;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    

}
