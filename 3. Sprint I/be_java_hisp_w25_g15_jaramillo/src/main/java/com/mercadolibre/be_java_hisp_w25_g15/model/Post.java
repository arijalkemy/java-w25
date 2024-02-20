package com.mercadolibre.be_java_hisp_w25_g15.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    static final AtomicInteger idGenerator = new AtomicInteger();
    @JsonIgnore
    int id;
    @JsonProperty("user_id")
    int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate date;
    Product product;
    int category;
    double price;
    @JsonProperty("has_promo")
    boolean hasPromo = false;
    double discount = 0;
    public Post(int user, LocalDate date, Product product, int category, double price) {
        this.id = idGenerator.incrementAndGet();
        this.userId = user;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
