package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {
    @Positive(message = "El id debe ser mayor a cero")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate date;

    @Valid
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacío")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
