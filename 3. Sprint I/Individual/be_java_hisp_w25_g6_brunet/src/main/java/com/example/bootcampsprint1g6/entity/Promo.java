package com.example.bootcampsprint1g6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Promo {
    Double discount;

    public double calcularPrecio(Post post){
        return post.getPrice() * (1-discount);
    }
}
