package com.example.bootcampsprint1g6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Seller seller;
    Integer postId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    Optional<Promo> promo;

    public Double calcularPrecioPromo(){
        return promo.map(value -> value.calcularPrecio(this)).orElseGet(() -> price);
    }

}
