package com.be_java_hisp_w25_g02_zanaboni.entity;

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
    Integer post_id;
    Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy") //TODO: Es posible agregar "yyyy-MM-dd@HH:mm:ss.SSSZ"
    LocalDate postDate;
    Product product;
    Integer category;
    Double price;
    Boolean has_promo;
    Double discount;
}
