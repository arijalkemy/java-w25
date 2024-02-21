package com.example.bootcampsprint1g6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostPromo extends Post{

    Boolean hasPromo;
    Double discount;

    @Builder(builderMethodName = "promoBuilder")
    public PostPromo(Seller seller, Integer postId, LocalDate date, Product product, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(seller, postId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }



}
