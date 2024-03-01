package com.example.bootcampsprint1g6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.*;

@Data
@Builder
public class ProductDTO {

    @NotNull(message = "La id no puede estar vacío.")
    @PositiveOrZero(message = "El id debe ser mayor o igual a cero.")
    @JsonProperty("product_id")
    Integer productId;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9., ]*$")
    @JsonProperty("product_name")
    String productName;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9., ]*$")
    String type;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9., ]*$")
    String brand;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9., ]*$")
    String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9., ]*$")
    String notes;
}
