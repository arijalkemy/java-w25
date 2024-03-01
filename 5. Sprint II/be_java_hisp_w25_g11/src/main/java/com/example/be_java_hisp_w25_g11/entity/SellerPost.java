package com.example.be_java_hisp_w25_g11.entity;

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
    private Integer Category;
    private Double price;
    private Seller seller;
}
