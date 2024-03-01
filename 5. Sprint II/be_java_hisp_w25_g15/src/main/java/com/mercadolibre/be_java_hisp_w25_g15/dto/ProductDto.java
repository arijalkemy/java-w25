package com.mercadolibre.be_java_hisp_w25_g15.dto;

import jakarta.validation.constraints.*;

public record ProductDto(


        /*
        Que el campo no esté vacío.
        Mayor 0
         */
        @Positive(message = "The product_id must be a positive integer") @NotNull(message = "The product_id cannot be null") Integer product_id,
        /*
        Que el campo no esté vacío.
        Longitud máxima de 40 caracteres.
        Que no posea caracteres especiales (%, &, $, etc), permite espacios.
         */
        @NotNull(message = "The product_name cannot be null")
        @Size(max = 40, message = "The product_name has a maximum length of a 40 characters")
        @NotBlank(message = "The product_name cannot be empty")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The product_name cannot contain special characters")
        String product_name,

        /*
        Que el campo no esté vacío.
        Longitud máxima de 15 caracteres.
        Que no posea caracteres especiales (%, &, $, etc)
         */
        @Size(max = 15, message = "The type has a maximum length of a 15 characters")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The type cannot contain special characters")
        @NotNull(message = "The type cannot be null")
        @NotBlank(message = "The type cannot be empty")
        String type,
        /*
        Que el campo no esté vacío.
        Longitud máxima de 25 caracteres.
        Que no posea caracteres especiales (%, &, $, etc)
         */
        @Size(max = 25, message = "The brand has a maximum length of a 25 characters")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The brand cannot contain special characters")
        @NotNull(message = "The brand cannot be null")
        @NotBlank(message = "The brand cannot be empty")
        String brand,
        /*
        Que el campo no esté vacío.
        Longitud máxima de 15 caracteres.
        Que no posea caracteres especiales (%, &, $, etc)
         */
        @Size(max = 15, message = "The color has a maximum length of a 15 characters")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The color cannot contain special characters")
        @NotNull(message = "The color cannot be null")
        @NotBlank(message = "The color cannot be empty")
        String color,
        /*
        Longitud máxima de 80 caracteres.
        Que no posea caracteres especiales (%, &, $, etc), permite espacios.
         */
        @Size(max = 80, message = "The notes has a maximum length of a 80 characters")
        @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The notes cannot contain special characters")
        @NotNull(message = "The notes cannot be null") String notes
) {
}
