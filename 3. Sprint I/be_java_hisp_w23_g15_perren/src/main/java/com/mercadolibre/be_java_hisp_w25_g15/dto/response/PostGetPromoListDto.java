package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;

import java.util.List;

public record PostGetPromoListDto(
        int user_id,
        String user_name,
        List<PostDto> posts
) {
}