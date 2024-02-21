package com.bootcamp.be_java_hisp_w25_g14.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Locale;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer postId;
    Integer userId;
    String date;
    Product product;
    Integer category;
    Double price;
    Boolean has_promo;
    Double discount;

    public Post (){
        this.has_promo=false;
    }
}


