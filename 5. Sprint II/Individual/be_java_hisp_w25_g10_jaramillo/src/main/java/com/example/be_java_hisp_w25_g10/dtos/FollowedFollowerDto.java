package com.example.be_java_hisp_w25_g10.dtos;

import com.example.be_java_hisp_w25_g10.entities.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record FollowedFollowerDto(
        @Positive
        int user_id,
        @NotNull
        @NotBlank
        @Size(max = 15)
        String user_name,
        @NotNull
        @NotEmpty
        @Valid
        List<User> users) {}