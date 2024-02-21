package org.socialmeli.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class Post {
    private Integer postId;
    private Integer userId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
    public static Integer postIdCounter = 0;

    public Post() {
        this.hasPromo = Boolean.FALSE;
        this.discount = 0.0;
    }

    public Post(Integer userId, LocalDate date, Product product, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = Boolean.FALSE;
        this.discount = 0.0;
    }
}
