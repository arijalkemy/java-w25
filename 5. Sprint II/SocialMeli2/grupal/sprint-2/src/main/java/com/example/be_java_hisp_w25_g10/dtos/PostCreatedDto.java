package com.example.be_java_hisp_w25_g10.dtos;

import com.example.be_java_hisp_w25_g10.entities.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Validated
public record PostCreatedDto(
        @Positive int user_id,
        @NotBlank String date,
        @Valid Product product,
        @Positive int category,
        @Positive
        @Max(value = 1000000, message = "El precio no puede ser mayor a 1.000.000")
        double price

)
{}
