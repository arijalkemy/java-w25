package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromDTO {
    private Integer userId;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
