package com.bootcamp.be_java_hisp_w25_g02.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @Min(value = 1, message = "El id de usuario no puede ser menor a 1")
        @JsonProperty("user_id")
        Integer userId,
        @Size(min = 1, max = 15, message = "El nombre de usuario debe tener entre 1 y 15 caracteres.")
        @NotBlank(message = "El nombre debe contener caracteres válidos, y no puede ser nulo.")
        @JsonProperty("user_name")
        String userName
) {
}
