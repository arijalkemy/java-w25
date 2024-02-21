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

    public Post(Integer id, PostDTO postDto) {
        this.id = id;
        this.date = postDto.getDate();
        this.productId = postDto.getProduct().getId();
        this.category = postDto.getCategory();
        this.price = postDto.getPrice();
        this.userId = postDto.getUserId();
    }
}
