package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Promo extends Post{
    Boolean hasPromo;
    Double discount;
    public Promo(Integer user_id, LocalDate date, Product product, Integer category, Double price, Boolean hasPromo,Double discount){
        super(user_id, date, product,category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
