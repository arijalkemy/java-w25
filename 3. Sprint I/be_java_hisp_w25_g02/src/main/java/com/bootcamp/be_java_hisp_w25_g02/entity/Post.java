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
    Integer post_id;
    Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy") //TODO: corroborar que formatee a dd-MM-yyyy. Es posible agregar "yyyy-MM-dd@HH:mm:ss.SSSZ"
    LocalDate postDate;
    Product product;
    Integer category;
    Double price;
}
