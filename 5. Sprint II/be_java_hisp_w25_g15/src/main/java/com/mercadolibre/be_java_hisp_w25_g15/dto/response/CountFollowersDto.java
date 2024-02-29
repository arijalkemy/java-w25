package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

public record CountFollowersDto (
        Integer userId,
        String userName,
        Integer followersCount
){
}
