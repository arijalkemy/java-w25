package com.socialMeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.socialMeli.dto.response.ProductDto;
import com.socialMeli.entity.Post;

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
//public class PromoPostDto extends PostDTO {
public class PromoPostDto {
    //segunda forma de hacer 10
    Integer id;
    @JsonProperty("user_id")
    Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    ProductDto product;
    Integer category;
    Double price;
    Boolean has_promo;
    Double discount;


    public PromoPostDto(Post p, ProductDto productDto) {
        this.id = p.getId();
        this.userId = p.getUserId();
        this.date = p.getDate();
        this.product = productDto;
        this.category = p.getCategory();
        this.price = p.getPrice();
        this.has_promo = p.getHas_promo();
        this.discount = p.getDiscount();
    }
}
