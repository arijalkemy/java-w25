package com.grupo08.socialmeli.dto;

import com.grupo08.socialmeli.entity.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostPromoDto {
    Integer userId;
    String date;
    Product product;
    Integer category;
    Double price;
    boolean has_promo;
    Double discount;
    
}
