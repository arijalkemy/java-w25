package com.example.bootcampsprint1g6.dto.response;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponseDTO {
    @JsonProperty("user_id")
    Integer userId;
    @JsonProperty("post_id")
    Integer postId;
    String date;
    ProductDTO product;
    Integer category;
    Double price;
    @JsonProperty("has_promo")
    Boolean hasPromo;
    Double discount;

}
