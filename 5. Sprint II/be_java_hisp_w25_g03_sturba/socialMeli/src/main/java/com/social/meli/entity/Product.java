package com.social.meli.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Product {
    Integer id;
    String name;
    String type;
    String color;
    String brand;
    String note;
}
