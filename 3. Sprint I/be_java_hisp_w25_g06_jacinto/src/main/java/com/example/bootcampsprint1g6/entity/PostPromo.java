package com.example.bootcampsprint1g6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostPromo extends Post {

    Double discount;

    @Builder(builderMethodName = "postPromo")
    public PostPromo(Seller seller, LocalDate date, Product product, Integer category, Double price, Double discount) {
        super(seller, date, product, category, price);
        this.discount = discount;
    }
}
