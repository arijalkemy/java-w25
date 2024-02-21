package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

import com.mercadolibre.be_java_hisp_w25_g15.model.Product;

public record PostListDto (
        int user_id,
        int post_id,
        String date,
        Product product,
        int category,
        double price,
        boolean has_promo,
        double discount
){
}
