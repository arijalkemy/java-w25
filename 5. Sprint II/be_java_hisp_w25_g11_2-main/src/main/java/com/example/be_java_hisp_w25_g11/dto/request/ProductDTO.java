package com.example.be_java_hisp_w25_g11.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("product_id")
    private Integer id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(message = "La longitud del nombre del producto no puede superar los 40 caracteres", max = 40)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "El nombre del producto no puede poseer caracteres especiales")
    @JsonProperty("product_name")
    private String productName;


    @NotBlank(message = "El tipo no puede estar vacío")
    @Size(message = "La longitud del tipo no puede superar los 15 caracteres", max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "El tipo no puede poseer caracteres especiales")
    @JsonProperty("type")
    private String type;

    @NotBlank(message = "La marca no puede estar vacío")
    @Size(message = "La longitud de la marca no puede superar los 25 caracteres", max = 25)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "la marca no puede poseer caracteres especiales")
    @JsonProperty("brand")
    private String brand;

    @NotBlank(message = "El color no puede estar vacío")
    @Size(message = "La longitud del color no puede superar los 15 caracteres", max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "El color no puede poseer caracteres especiales")
    @JsonProperty("color")
    private String color;

    @Size(message = "Las notas no pueden superar los 80 caracteres", max = 80)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Las notas no pueden poseer caracteres especiales")
    @JsonProperty("notes")
    private String notes;
}
