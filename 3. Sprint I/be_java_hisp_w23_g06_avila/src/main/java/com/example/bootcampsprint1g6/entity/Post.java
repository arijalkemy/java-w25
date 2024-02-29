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
    @ToString.Exclude
    Seller seller;
    Integer postId;
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    Boolean hasPromo = false;
    Double discount = 0.0;
}
