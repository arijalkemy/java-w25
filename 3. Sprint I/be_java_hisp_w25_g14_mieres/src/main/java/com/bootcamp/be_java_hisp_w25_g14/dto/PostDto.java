package com.bootcamp.be_java_hisp_w25_g14.dto;

import com.bootcamp.be_java_hisp_w25_g14.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto {
    Integer user_id;
    String date;
    ProductDto product;
    Integer category;
    Double price;
    boolean has_promo;
    Double discount;

    public PostDto(Integer user_id, String date, ProductDto product, Integer category, Double price) {
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo=false;
        this.discount=0.0;
    }
}
