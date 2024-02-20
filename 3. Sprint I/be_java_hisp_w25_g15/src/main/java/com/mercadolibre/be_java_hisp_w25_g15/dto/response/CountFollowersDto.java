package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

public record CountFollowersDto (
        int userId,
        String userName,
        int followersCount
){
}
