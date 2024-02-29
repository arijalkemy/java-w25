package com.mercadolibre.be_java_hisp_w25_g15.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    static final AtomicInteger idGenerator = new AtomicInteger();
    @JsonProperty("post_id")
    Integer id;
    @JsonProperty("user_id")
    Integer userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate date;
    Product product;
    Integer category;
    Double price;
    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        this.id = idGenerator.incrementAndGet();
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
    public void setPostIdAuto(){
        this.id = idGenerator.incrementAndGet();
    }
}
