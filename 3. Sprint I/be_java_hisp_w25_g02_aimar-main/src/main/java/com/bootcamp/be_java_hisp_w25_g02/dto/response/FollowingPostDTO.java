package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;

import java.util.List;

public record FollowingPostDTO(
    Integer user_id,
    List<PostDTO> posts
) {
}
