package com.grupo08.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FollowDto {
    @JsonProperty("user_id")
    //@NotBlank(message = "El id no puede estar vacio.")
    @Positive(message = "El id debe ser mayor a 0.")
    private Integer userId;

    @JsonProperty("user_name")
    @Size(max = 15, message = "Maximo 15 caracteres")
    private String userName;
}
