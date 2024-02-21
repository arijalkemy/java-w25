package org.socialmeli.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {
    private Integer postId;
    private Integer userId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    public static Integer postIdCounter = 0;

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
