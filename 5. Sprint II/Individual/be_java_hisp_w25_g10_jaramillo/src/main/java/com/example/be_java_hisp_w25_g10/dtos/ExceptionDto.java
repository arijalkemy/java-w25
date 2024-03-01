package com.example.be_java_hisp_w25_g10.dtos;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record ExceptionDto(
        @NotNull
        String message) {
}
