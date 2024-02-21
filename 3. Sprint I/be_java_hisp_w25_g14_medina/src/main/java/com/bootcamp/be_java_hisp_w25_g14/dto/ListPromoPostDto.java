package com.bootcamp.be_java_hisp_w25_g14.dto;

import java.util.List;

public record ListPromoPostDto(
        Integer user_id,
        String user_name,
        List<PromoPostDto> posts
        ) {
}
