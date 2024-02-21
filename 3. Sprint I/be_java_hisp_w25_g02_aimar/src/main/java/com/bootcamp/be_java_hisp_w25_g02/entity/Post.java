package com.bootcamp.be_java_hisp_w25_g02.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer post_id;
    Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy") //TODO: corroborar que formatee a dd-MM-yyyy. Es posible agregar "yyyy-MM-dd@HH:mm:ss.SSSZ"
    LocalDate postDate;
    Product product;
    Integer category;
    Double price;
    Boolean has_promo;
    Double discount;

    public Post(Integer post_id, Integer user_id, LocalDate postDate, Product product, Integer category, Double price) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.postDate = postDate;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
