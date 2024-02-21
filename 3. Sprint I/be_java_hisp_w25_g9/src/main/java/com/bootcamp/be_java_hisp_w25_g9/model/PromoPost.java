package com.bootcamp.be_java_hisp_w25_g9.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class PromoPost extends Post{
    boolean hasPromo;
    double discount;
    public PromoPost(int id, int userId, int category, LocalDate date, Product product, double price, boolean hasPromo, double discount) {
        super(id, userId, category, date, product, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
