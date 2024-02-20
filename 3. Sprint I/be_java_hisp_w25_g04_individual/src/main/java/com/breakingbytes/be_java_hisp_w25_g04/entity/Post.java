package com.breakingbytes.be_java_hisp_w25_g04.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    @NonNull
    int userId;
    @NonNull
    LocalDate date;
    @NonNull
    Product product;
    @NonNull
    int category;
    @NonNull
    double price;
    boolean has_promo = false;
    double discount;
}
