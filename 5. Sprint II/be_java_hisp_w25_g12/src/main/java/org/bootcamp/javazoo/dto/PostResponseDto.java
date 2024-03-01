package org.bootcamp.javazoo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
