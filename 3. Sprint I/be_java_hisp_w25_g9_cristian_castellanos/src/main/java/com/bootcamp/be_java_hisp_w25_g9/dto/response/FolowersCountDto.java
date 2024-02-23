package com.bootcamp.be_java_hisp_w25_g9.dto.response;

public record FolowersCountDto(
    int user_id,
    String user_name,
    int followers_count
) { }
