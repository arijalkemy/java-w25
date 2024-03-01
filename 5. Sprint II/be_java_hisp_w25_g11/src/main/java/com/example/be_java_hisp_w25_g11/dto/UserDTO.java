package com.example.be_java_hisp_w25_g11.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotNull(message = "El  id del usuario no puede estar vacío")
    @Positive(message = "El id del usuario debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(message = "La longitud del nombre de usuario no puede superar los 15 caracteres", max = 15)
    @JsonProperty("user_name")
    private String name;
}
