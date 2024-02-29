package com.example.be_java_hisp_w25_g01.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDTO {
    //US 0005
    @NotNull(message = "El  id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    Integer user_id;

    Integer post_id;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate date;

    @Valid
    ProductDTO product;

    @NotNull(message = "El campo no puede estar vacío")
    Integer category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value=10000000, message = "El precio máximo por producto es de 10.000.000")
    Double price;
}
