package com.bootcamp.be_java_hisp_w25_g9.dto.response;

import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;

import java.util.List;

public record FollowedDto(
        int user_id,
        String user_name,
        List<UserDto> followed
) {
}
