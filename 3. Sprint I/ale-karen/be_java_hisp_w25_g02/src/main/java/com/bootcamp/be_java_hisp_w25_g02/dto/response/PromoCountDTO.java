package com.bootcamp.be_java_hisp_w25_g02.dto.response;

public record PromoCountDTO(
        int user_id,
        String user_name,

        int promo_products_count
) {
}
