package com.bootcamp.be_java_hisp_w25_g9.dto.response;

import java.util.List;

public record FollowedPostsDto(
        Integer user_id,
        List<PostResponseDto> posts
) {
}
