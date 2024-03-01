package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostDto {
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;

    public PostDto(Integer postId, Integer userId, LocalDate date, ProductDto product, Integer category, Double price) {
        this.postId = postId;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}