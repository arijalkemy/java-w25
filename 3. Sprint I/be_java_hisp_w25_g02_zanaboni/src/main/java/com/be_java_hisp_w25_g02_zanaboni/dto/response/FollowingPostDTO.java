package com.be_java_hisp_w25_g02_zanaboni.dto.response;

import java.util.List;

public record FollowingPostDTO(Integer user_id,
                               List<PostDTO> posts) {
}
