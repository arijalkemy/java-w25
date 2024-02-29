package com.mercadolibre.be_java_hisp_w25_g15.dto.request;

public record UnfollowDto(
        Integer userId,
        Integer unfollowUserId
){
}