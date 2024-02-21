package com.bootcamp.be_java_hisp_w25_g9.dto.response;

import java.util.List;

public record PromoProductsListDto(
        int user_id,
        String user_name,
        List<PostResponseDto> postResponseDto
) {}
