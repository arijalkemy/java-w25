package com.socialMeli.entity;

import com.socialMeli.dto.request.PostDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    Integer id;
    LocalDate date;
    Integer productId;
    Integer category;
    Double price;
    Integer userId;
    Boolean has_promo = false;
    Double discount;

    public Post(Integer id, PostDTO postDto) {
        this.id = id;
        this.date = postDto.getDate();
        this.productId = postDto.getProduct().getId();
        this.category = postDto.getCategory();
        this.price = postDto.getPrice();
        this.userId = postDto.getUserId();
        //forma1
        //this.has_promo = postDto.getHas_promo();
        //this.discount = postDto.getDiscount();
    }

    //forma2 - para hacer más declarativo el constructor pasando por parámetro explicitamente has_promo y discoun.
    public Post(Integer id, Boolean has_promo, Double discount ,PostDTO postDto) {
        this(id, postDto);
        this.has_promo = postDto.getHas_promo();
        this.discount = postDto.getDiscount();}

}
