package org.socialmeli.util;

import lombok.Data;
import org.socialmeli.dto.response.ProductDto;


@Data
public class NewPost {
    private Integer userId;
    private String date;
    private ProductDto product;
    private Integer category;
    private Double price;

    public NewPost(Integer userId, String date, ProductDto product, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
