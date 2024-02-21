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
    Integer post_id;
    Integer user_id;
    String date;
    ProductDto product;
    Integer category;
    Double price;

}
