package org.socialmeli.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserIdDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer userId;

    public UserIdDto(Integer userId) {
        this.userId = userId;
    }
}
