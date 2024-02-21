package com.grupo08.socialmeli.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    int userId;
    LocalDate date;
    Product product;
    int category;
    Double price;
    boolean hasPromo = false;
    Double discount = 0.0;

    public Post(int userId, String date, Product product, int category, double price) {
        this.userId = userId;
        LocalDate datetime = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.date = datetime;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(int userId, String date, Product product, int category, double price, boolean hasPromo, double discount) {
        this.userId = userId;
        LocalDate datetime = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.date = datetime;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }


}
