package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.List;

public record FollowerListDTO(

        @Min(value = 1, message = "El id de usuario no puede ser menor a 1.")
                @JsonProperty("user_id")
        Integer userId,
        @Size(min = 1, max = 15, message = "El nombre debe tener entre 1 y 15 caracteres.")
        @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "El nombre no debe contener caracteres especiales.")
        @NotBlank(message = "El nombre de usuario no puede estar vacio")
                @JsonProperty("user_name")
        String userName,
        @NotNull
        List<UserDTO> followers
) {
}
