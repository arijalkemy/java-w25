package com.bootcamp.be_java_hisp_w25_g02.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer postId;
    Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy") //TODO: corroborar que formatee a dd-MM-yyyy. Es posible agregar "yyyy-MM-dd@HH:mm:ss.SSSZ"
    LocalDate postDate;
    Product product;
    Integer category;
    Double price;
    Boolean hasPromo;
    Double discount;

    public Post(Integer postId, Integer userId, LocalDate postDate, Product product, Integer category, Double price) {
        this.postId = postId;
        this.userId = userId;
        this.postDate = postDate;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }
}
