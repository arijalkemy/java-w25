package com.example.bootcampsprint1g6.dto.response;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoResponseDTO extends PostResponseDTO {

    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;

    @Builder(builderMethodName = "promoBuilder")
    public PostPromoResponseDTO(Integer userId, Integer postId, String date, ProductDTO product, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(userId, postId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
