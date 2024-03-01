package com.mercadolibre.be_java_hisp_w25_g15.dto.response;

import java.util.List;

public record UserDto (
        Integer id,
        String username,
        List<UserListDto> followers,
        List<UserListDto> followed
) {
}
