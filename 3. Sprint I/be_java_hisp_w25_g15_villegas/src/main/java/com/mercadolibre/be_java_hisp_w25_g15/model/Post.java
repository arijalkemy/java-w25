package com.mercadolibre.be_java_hisp_w25_g15.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Post {
    static final AtomicInteger idGenerator = new AtomicInteger();
    @Builder.Default private final int id = idGenerator.incrementAndGet();
    User user;
    LocalDate date;
    Product product;
    int category;
    double price;
    boolean has_promo;
    double discount;
}
