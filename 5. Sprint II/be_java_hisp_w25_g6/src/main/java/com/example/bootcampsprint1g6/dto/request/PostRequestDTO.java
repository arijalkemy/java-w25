package com.example.bootcampsprint1g6.dto.request;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestDTO {

    @NotNull(message = "El id no puede estar vacío.")
    @PositiveOrZero(message = "El id debe ser mayor o igual a cero.")
    @JsonProperty("user_id")
    private Integer userId;
    @NotBlank(message = "La fecha no puede estar vacía.")
    @Pattern(regexp = "^([0-2][0-9]|3[0-1])(-)(0[1-9]|1[0-2])\\2(\\d{4})$", message = "Formato de fecha incorrecto")
    private String date;
    @Valid
    private ProductDTO product;
    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;
    @PositiveOrZero(message = "El precio debe ser un número mayor o igual a 0(cero).")
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

}
