package com.bootcamp.be_java_hisp_w25_g9.dto.request;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostRequestDto(
        @NotNull(message = "El id no puede estar vacío.")
        @Min(value = 0, message = "El id debe ser mayor a cero")
        Integer user_id,
        @NotNull(message="La fecha no puede estar vacía")
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate date,
        @Valid
        @NotNull(message = "El producto no puede estar vacío.")
        ProductDto product,
        @NotNull(message = "El campo no puede estar vacío.")
        Integer category,
        @NotNull(message = "El campo no puede estar vacío.")
        @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
        Double price
) {
}
