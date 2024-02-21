package com.example.bootcampsprint1g6.dto.request;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRequestDTO {

    @JsonProperty("user_id")
    Integer userId;
    String date;
    ProductDTO product;
    Integer category;
    Double price;
    @JsonProperty("has_promo")
    Optional<Boolean> hasPromo;
    Optional<Double> discount;

}
