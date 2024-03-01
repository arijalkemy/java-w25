package org.socialmeli.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FollowingListReqDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer userId;
    private String order;

    public FollowingListReqDto(Integer userId, String order) {
        this.userId = userId;
        this.order = order;
    }
}
