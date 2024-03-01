package com.bootcamp.be_java_hisp_w25_g9.dto;

import jakarta.validation.constraints.*;

public record ProductDto(
        @NotNull(message = "El id no puede estar vacío")
        @Min(value = 0, message = "El id debe ser mayor a cero")
        Integer product_id,
        @NotNull(message = "El campo no puede ser nulo.")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
        @Pattern(regexp = "\\w[\\w|\\s]*", message = "El campo no puede poseer caracteres especiales.")
        String product_name,
        @NotNull(message = "El campo no puede estar vacío.")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
        @Pattern(regexp = "\\w[\\w|\\s]*", message = "El campo no puede poseer caracteres especiales.")
        String type,
        @NotNull(message = "El campo no puede estar vacío.")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
        @Pattern(regexp = "\\w[\\w|\\s]*", message = "El campo no puede poseer caracteres especiales.")
        String brand,
        @NotNull(message = "El campo no puede estar vacío.")
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
        @Pattern(regexp = "\\w[\\w|\\s]*", message = "El campo no puede poseer caracteres especiales.")
        String color,
        @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
        @Pattern(regexp = "\\w[\\w|\\s]*", message = "El campo no puede poseer caracteres especiales.")
        String notes
) {
}
