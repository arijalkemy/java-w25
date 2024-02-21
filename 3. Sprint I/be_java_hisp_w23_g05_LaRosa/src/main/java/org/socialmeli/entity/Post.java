package org.socialmeli.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {
    protected Integer postId;
    protected Integer userId;
    protected LocalDate date;
    protected Product product;
    protected Integer category;
    protected Double price;
    public static Integer postIdCounter = 0;

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

}
