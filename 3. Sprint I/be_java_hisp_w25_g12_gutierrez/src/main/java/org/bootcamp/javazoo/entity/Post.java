package org.bootcamp.javazoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;

    public Post(Integer id, LocalDate date, Product product, Integer category, Double price) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = false;
        this.discount = 0.0;
    }
}
