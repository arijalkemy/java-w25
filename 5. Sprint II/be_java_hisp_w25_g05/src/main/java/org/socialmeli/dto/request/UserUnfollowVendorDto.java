package org.socialmeli.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserUnfollowVendorDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer userId;
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer vendorId;

    public UserUnfollowVendorDto(Integer userId, Integer vendorId) {
        this.userId = userId;
        this.vendorId = vendorId;
    }
}
