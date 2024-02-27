package org.bootcamp.javazoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {

    private int user_id;
    private int post_id;
    private String date; // "date": "01-05-2021",
    private ProductDto product;
    private int category;
    private double price;
}
