package org.socialmeli.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {
    private Integer postId;
    private Integer userId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    public static Integer postIdCounter = 0;

    public Post() {
        this.postId = null;
        this.userId = null;
        this.date = null;
        this.product = null;
        this.category = null;
        this.price = null;
    }

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
