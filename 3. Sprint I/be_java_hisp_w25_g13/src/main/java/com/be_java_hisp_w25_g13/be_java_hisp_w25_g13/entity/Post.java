package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    static Integer num_post = 0;
    Integer user_id;
    Integer post_id;
    LocalDate date;
    Product product;
    Integer category;
    Double price;

    public Post(Integer user_id, LocalDate date, Product product, Integer category, Double price){
        num_post += 1;
        this.post_id = num_post;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;

    }
}
