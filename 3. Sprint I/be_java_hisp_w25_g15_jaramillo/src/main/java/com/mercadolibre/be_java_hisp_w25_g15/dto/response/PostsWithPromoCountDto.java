package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostsWithPromoCountDto(
        @JsonProperty("user_id") int userId,
        @JsonProperty("user_name") String userName,
        @JsonProperty("promo_products_count") long promoProductsCount
) {
}
