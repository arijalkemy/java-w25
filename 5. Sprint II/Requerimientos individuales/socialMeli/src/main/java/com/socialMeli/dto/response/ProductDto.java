package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.*;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Positive(message = "El id debe ser un valor positivo")
    @NotNull(message = "El id de usuario no puede estar vacio")
    @JsonProperty("product_id")
    Integer id;

    @NotNull(message = "El nombre del producto no puede estar vacio")
    @Size(min = 1, max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "La cadena no es válida")
    @JsonProperty("product_name")
    String name;

    @NotNull(message = "El tipo no puede estar vacio")
    @Size(min = 1, max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "La cadena no es válida")
    String type;

    @NotNull(message = "El nombre de la marca no puede estar vacio")
    @Size(min = 1, max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "La cadena no es válida")
    String brand;

    @NotNull(message = "El color no puede estar vacio")
    @Size(min = 1, max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "La cadena no es válida")
    String color;

    @Size(min = 1, max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "La cadena no es válida")
    @JsonProperty("notes")
    String note;
}
