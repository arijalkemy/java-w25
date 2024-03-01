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
    Integer userId;
    Integer postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate date;
    Product product;
    Integer category;
    Double price;
}


