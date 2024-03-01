package com.bootcamp.be_java_hisp_w25_g02.dto.request;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PostDTO(

        @NotNull(message = "El id de usuario no puede ser nulo")
        @Min(value = 1, message = "El id de usuario debe ser mayor a 0")
        @JsonProperty("user_id")
        Integer userId,
        @JsonFormat(pattern = "dd-MM-yyyy")
        @NotNull(message = "La fecha no puede ser nula")
        LocalDate date,
        @Valid
        @NotNull(message = "El producto no puede ser nulo")
        ProductDTO product,
        @NotNull(message = "La categoria no puede ser nula")
        Integer category,
        @NotNull(message = "El precio no puede ser nulo")
        @Positive(message = "el precio no puede ser menor o igual a 0")
        @Max(value = 10_000_000, message = "El precio máximo por producto es de 10.000.000")
        Double price
) {
}
