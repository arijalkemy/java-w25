package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VendorPromoProductCountDto(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName,
        @JsonProperty("promo_products_count")
        Integer promoProductCount

) {
}
