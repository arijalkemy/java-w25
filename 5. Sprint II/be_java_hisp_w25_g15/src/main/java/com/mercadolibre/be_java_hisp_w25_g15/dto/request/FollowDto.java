package com.mercadolibre.be_java_hisp_w25_g15.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FollowDto (

        Integer userId,
        Integer userIdToFollow
){
}
