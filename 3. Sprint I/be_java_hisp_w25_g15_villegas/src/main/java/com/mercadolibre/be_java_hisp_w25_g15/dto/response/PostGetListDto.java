package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;

import java.util.List;

public record PostGetListDto (
        int id,
        List<PostListDto> posts
) {
}