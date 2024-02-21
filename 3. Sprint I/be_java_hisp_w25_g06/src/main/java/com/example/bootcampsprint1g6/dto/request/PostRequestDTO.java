package com.example.bootcampsprint1g6.dto.request;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestDTO {

    @JsonProperty("user_id")
    private Integer userId;
    private String date;
    private ProductDTO product;
    private Integer category;
    private Double price;

}
