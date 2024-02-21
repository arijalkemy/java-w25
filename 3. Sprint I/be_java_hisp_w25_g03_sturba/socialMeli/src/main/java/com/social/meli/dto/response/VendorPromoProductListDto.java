package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record VendorPromoProductListDto(
        @JsonProperty("user_id")
        Integer userId,
        @JsonProperty("user_name")
        String userName,
        @JsonProperty("posts")
        List<PromoPostResponseDto> promoPostResponseDtoList
) {
}
