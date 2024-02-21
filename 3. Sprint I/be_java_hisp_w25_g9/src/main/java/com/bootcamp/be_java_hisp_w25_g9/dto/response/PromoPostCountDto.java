package com.bootcamp.be_java_hisp_w25_g9.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PromoPostCountDto (
        @JsonProperty("user_id")
        int userId,
        @JsonProperty("user_name")
        String userName,
        @JsonProperty("promo_products_count")
        int promoProductsCount
){
}

