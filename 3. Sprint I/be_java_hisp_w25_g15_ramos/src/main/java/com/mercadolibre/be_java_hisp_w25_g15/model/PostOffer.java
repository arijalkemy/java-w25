package com.mercadolibre.be_java_hisp_w25_g15.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class PostOffer extends Post {
    boolean has_promo;
    double discount;
    public PostOffer(int user, LocalDate date, Product product, int category, double price, boolean has_promo, double discount) {
        super(user, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}