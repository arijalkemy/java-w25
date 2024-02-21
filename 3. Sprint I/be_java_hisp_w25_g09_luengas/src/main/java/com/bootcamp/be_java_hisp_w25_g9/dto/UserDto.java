package com.bootcamp.be_java_hisp_w25_g9.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDto(int user_id, String user_name) {}
