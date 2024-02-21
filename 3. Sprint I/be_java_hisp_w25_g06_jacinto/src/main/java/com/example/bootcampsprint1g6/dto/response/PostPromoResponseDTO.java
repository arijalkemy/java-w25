package com.example.bootcampsprint1g6.dto.response;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PostPromoResponseDTO extends PostResponseDTO {
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;

    @Builder(builderMethodName = "postPromoResponseDTO")
    public PostPromoResponseDTO(Integer userId, Integer postId, String date, ProductDTO product,
                                Integer category, Double price, Boolean hasPromo, Double discount){
        super(userId, postId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
