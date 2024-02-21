package com.bootcamp.be_java_hisp_w25_g02.dto.response;

public record PromoPostsCountDTO(
        Integer user_id,
        String user_name,
        Integer promo_products_count
) {}
