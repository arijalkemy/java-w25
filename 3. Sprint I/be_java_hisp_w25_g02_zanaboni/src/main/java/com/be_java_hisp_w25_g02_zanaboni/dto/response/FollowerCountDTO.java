package com.be_java_hisp_w25_g02_zanaboni.dto.response;

public record FollowerCountDTO(
        Integer user_id,
        String user_name,
        Long followers_count

) {
}
