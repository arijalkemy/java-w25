package com.example.be_java_hisp_w25_g10.dtos;

import com.example.be_java_hisp_w25_g10.entities.User;

import java.util.List;

public record FollowedFollowerDto(int user_id, String user_name, List<User> users) {}