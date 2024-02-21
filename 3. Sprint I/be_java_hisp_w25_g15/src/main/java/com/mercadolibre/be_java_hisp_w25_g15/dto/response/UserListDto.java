package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

public record UserListDto(
        int user_id,
        String username
){
    public String getUsername() {
        return username;
    }
}