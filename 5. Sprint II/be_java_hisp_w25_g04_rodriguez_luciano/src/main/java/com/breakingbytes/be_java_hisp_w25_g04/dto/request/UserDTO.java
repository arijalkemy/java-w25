package com.breakingbytes.be_java_hisp_w25_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    @JsonProperty("user_id")
    @NotNull(message = "El  id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    Integer id;
    @JsonProperty("user_name")
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max = 15, message = "El nombre no puede tener mas de 15 caracteres.")
    String name;
}
