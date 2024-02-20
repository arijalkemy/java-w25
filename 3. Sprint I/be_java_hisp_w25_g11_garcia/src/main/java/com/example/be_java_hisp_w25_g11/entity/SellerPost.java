package com.example.be_java_hisp_w25_g11.entity;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class SellerPost {
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
    private Seller seller;

    public SellerPost(Integer userId, LocalDate date, Product product, Integer category, Double price, Seller seller) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.seller = seller;
        this.hasPromo = false;
        this.discount = 0.0;
    }

    public SellerPost(Integer userId, LocalDate date, Product product, Integer category, Double price, Boolean hasPromo, Double discount, Seller seller) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
        this.seller = seller;
    }
}
