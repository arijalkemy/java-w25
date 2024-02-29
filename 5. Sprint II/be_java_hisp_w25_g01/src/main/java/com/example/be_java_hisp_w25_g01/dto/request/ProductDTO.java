package com.example.be_java_hisp_w25_g01.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    //US 0005
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    Integer product_id;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max= 40, message="La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 A-zÀ-ú]*$", message = "El campo no puede poseer caracteres especiales.")
    String product_name;


    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max= 15, message="La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 A-zÀ-ú]*$", message = "El campo no puede poseer caracteres especiales.")
    String type;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max= 25, message="La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 A-zÀ-ú]*$", message = "El campo no puede poseer caracteres especiales.")
    String brand;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max= 15, message="La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 A-zÀ-ú]*$", message = "El campo no puede poseer caracteres especiales.")
    String color;

    @Size(max= 80, message="La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 A-zÀ-ú]*$", message = "El campo no puede poseer caracteres especiales.")
    String notes;
}
