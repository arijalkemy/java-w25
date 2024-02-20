package com.be_java_hisp_w25_g02_zanaboni.dto.response;

import java.util.List;

public record FollowerListDTO(
        Integer user_id,
        String user_name,
        List<UserDTO> followers
) {
}
