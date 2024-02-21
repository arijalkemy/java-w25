package com.bootcamp.be_java_hisp_w25_g14.dto;

import java.util.List;

public record PostsBetweenPriceRangeDto(
        String price_range,
        List<PostDto> posts
) {
}
