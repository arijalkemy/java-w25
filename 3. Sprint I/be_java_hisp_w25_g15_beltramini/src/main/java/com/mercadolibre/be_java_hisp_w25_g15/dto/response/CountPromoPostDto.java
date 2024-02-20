package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

public record CountPromoPostDto(
        int userId,
        String userName,
        int promoProductsCount
) {
}
