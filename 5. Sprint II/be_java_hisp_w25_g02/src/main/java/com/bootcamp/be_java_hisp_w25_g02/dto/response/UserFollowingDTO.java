package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserFollowingDTO(

        @Min(value = 1, message = "El id de usuario no puede ser menor a 1")
        @JsonProperty("user_id")
        Integer userId,
        @NotBlank(message = "El nombre de usuario no puede estar vacio")
        @Size(min = 1, max = 15, message = "El nombre debe tener entre 1 y 15 caracteres.")
        @JsonProperty("user_name")
        String userName,
        List<UserDTO> followed
) {
}
