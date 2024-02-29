package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.*;

public record ProductDto(
        @JsonProperty("product_id")
        @NotNull(message = "La id no puede estar vacía.")
        @Min(value = 1, message = "El id debe ser mayor a cero.")
        Integer productId,

        @JsonProperty("product_name")
        @NotNull(message = "El campo no puede estar vacío.")
        @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
        @Pattern(regexp = "^[^<>!@#%&]*$", message = "El campo no puede poseer caracteres especiales.")
        String productName,

        @JsonProperty("type")
        @NotNull(message = "El campo no puede estar vacío.")
        @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
        @Pattern(regexp = "^[^<>!@#%&]*$", message = "El campo no puede poseer caracteres especiales.")
        String type,

        @JsonProperty("brand")
        @NotNull(message = "El campo no puede estar vacío.")
        @Size(max = 20, message = "La longitud no puede superar los 20 caracteres.")
        @Pattern(regexp = "^[^<>!@#%&]*$", message = "El campo no puede poseer caracteres especiales.")
        String brand,

        @JsonProperty("color")
        @NotNull(message = "El campo no puede estar vacío.")
        @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
        @Pattern(regexp = "^[^<>!@#%&]*$", message = "El campo no puede poseer caracteres especiales.")
        String color,

        @JsonProperty("notes")
        @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
        @Pattern(regexp = "^[^<>!@#%&]*$", message = "El campo no puede poseer caracteres especiales.")
        String notes
) {
}
