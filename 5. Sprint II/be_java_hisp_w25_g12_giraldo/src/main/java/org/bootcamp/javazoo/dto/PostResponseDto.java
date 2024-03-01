package org.bootcamp.javazoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponseDto {

    private Integer user_id;

    private Integer post_id;

    private String date;

    private ProductDto product;

    private Integer category;

    private Double price;

}
