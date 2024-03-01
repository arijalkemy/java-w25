package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacío")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "El campo no puede poseer caracteres especiales")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "El campo no puede poseer caracteres especiales")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "El campo no puede poseer caracteres especiales")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "El campo no puede poseer caracteres especiales")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    private String color;

    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "El campo no puede poseer caracteres especiales")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    private String notes;
}
