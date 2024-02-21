package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.meli.entity.PromoPost;
import com.social.meli.entity.Product;

public class PromoPostResponseDto extends PostDto {
    @JsonProperty("has_promo")
    boolean hasPromo;
    Double discount;

    public PromoPostResponseDto(PromoPost promoPost, Product product) {
        super(promoPost, product);
        this.hasPromo = true;
        this.discount = promoPost.getDiscount();
    }
}
