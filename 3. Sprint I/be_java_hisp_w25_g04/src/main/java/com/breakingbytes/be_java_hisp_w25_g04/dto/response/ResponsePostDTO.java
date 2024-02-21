package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponsePostDTO {
    int userId; //Id of Seller
    int postId; //Id of Post
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate date; //Format "01-05-2021"
    Product product;
    int category;
    double price;


}


