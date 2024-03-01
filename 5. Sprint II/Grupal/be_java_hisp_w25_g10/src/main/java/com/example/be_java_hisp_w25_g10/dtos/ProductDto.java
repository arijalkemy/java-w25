package com.example.be_java_hisp_w25_g10.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

@Validated
public record ProductDto(@Positive int productId,

                         @NotBlank(message = "El campo no puede estar vacío")
                         @Size(min = 1, max = 40, message = "La longitud no puede superar los 40 caracteres")
                         @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
                         @JsonProperty("product_name")
                         String productName,

                         @NotBlank(message = "El campo no puede estar vacío")
                         @Size(min = 1, max = 15, message = "La longitud no puede superar los 15 caracteres")
                         @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
                         String type,

                         @NotBlank(message = "El campo no puede estar vacío")
                         @Size(min = 1, max = 25, message = "La longitud no puede superar los 25 caracteres")
                         @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
                         String brand,
                         @NotNull(message = "El campo no puede estar vacío")
                         @NotBlank(message = "El campo no puede estar vacío")
                         @Size(min = 1, max = 15, message = "La longitud no puede superar los 25 caracteres")
                         @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
                         String color,

                         @NotBlank(message = "El campo no puede estar vacío")
                         @Size(min = 1, max = 80, message = "La longitud no puede superar los 80 caracteres")
                         @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
                         String notes,
                         @NotBlank(message = "El campo no puede estar vacío")
                         int category,
                         @Positive
                         @NotBlank(message = "El campo no puede estar vacío")
                         @Max(10000000)
                         double price) { }
