package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post2DTO {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
}
