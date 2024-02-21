package com.example.be_java_hisp_w25_g11_grisales.entity;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerPost {
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Seller seller;
    private boolean hasPromo = false;
    private double discount = 0.0;

    public SellerPost(Integer userId,
                      Integer postId,
                      LocalDate date,
                      Product product,
                      Integer category,
                      Double price,
                      Seller seller) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.seller = seller;
    }
}
