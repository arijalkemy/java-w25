package com.example.be_java_hisp_w25_g10.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record PostsDto (
        @Positive
        int userId,
        @NotEmpty
        @Valid
        List<PostDto> posts) { }
