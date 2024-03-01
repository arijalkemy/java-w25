package com.grupo08.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @JsonProperty("product_id")
    //@NotBlank(message = "El id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a 0.")
    private Integer productId;
    @JsonProperty("product_name")
    @NotEmpty(message = "El campo product_name no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;
    @NotBlank(message = "El tipo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;
    @NotBlank(message = "El campo brand no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotBlank(message = "El color no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
