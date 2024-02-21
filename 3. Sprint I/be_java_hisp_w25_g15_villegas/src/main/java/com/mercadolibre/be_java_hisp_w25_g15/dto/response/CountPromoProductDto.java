package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

public record CountPromoProductDto(
        int user_id,
        String user_name,
        int promo_products_count
) {
}
