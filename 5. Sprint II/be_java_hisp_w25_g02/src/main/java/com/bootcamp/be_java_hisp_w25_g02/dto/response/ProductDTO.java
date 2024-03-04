package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductDTO(
        @Min(value = 1, message = "El id de producto debe ser mayor a 0")
        @JsonProperty("product_id")
        Integer productId,
        @NotBlank(message = "El nombre del producto no puede ser nulo, ni tampoco una cadena de caracteres vacía.")
        @Size(max = 40, message = "El nombre del producto no puede exceder los 40 caracteres")
        @JsonProperty("product_name")
        String productName,
        @NotBlank(message = "El tipo no puede estar vacio")
        String type,
        @NotBlank(message = "El brand de producto no puede estar vacio")
        String brand,
        @NotBlank(message = "El color no puede estar vacio")
        String color,
        @Nullable
        String notes
) {
}
