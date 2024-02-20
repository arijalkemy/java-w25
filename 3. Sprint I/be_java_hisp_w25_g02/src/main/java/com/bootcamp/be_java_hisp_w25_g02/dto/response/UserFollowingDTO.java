package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import java.util.List;

public record UserFollowingDTO(
        Integer user_id,
        String user_name,
        List<UserDTO> followed
) {
}
