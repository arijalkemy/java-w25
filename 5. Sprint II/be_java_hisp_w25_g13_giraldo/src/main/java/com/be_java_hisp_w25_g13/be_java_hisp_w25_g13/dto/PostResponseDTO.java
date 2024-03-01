package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponseDTO {
    private Integer userId;
    private Integer postId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
}
