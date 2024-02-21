package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.meli.entity.Post;
import com.social.meli.entity.Product;
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
public class PostDto {
    Integer id;
    @JsonProperty("user_id")
    Integer userId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;

    public PostDto(Post post, Product product) {
        this.id = post.getId();
        this.userId = post.getUserId();
        this.date = post.getDate();
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.product = product;
    }
}
