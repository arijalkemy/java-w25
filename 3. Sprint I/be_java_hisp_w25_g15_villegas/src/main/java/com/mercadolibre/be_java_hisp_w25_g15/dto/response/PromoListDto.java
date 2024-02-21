package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;

import java.util.List;

public record PromoListDto(
    int userId,
    String user_name,
    List<PostListDto> postListDtos
) {
}
