package org.socialmeli.entity;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PostPromo extends Post{

   private Boolean has_promo;
   private Double discount;

    public PostPromo(Boolean has_promo, Double discount) {
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public PostPromo(Integer userId, LocalDate date, Product product, Integer category, Double price, Boolean has_promo, Double discount) {
        super(userId, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public PostPromo(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        super(userId, date, product, category, price);
        this.has_promo = false;
        this.discount = 0.0;
    }
}
