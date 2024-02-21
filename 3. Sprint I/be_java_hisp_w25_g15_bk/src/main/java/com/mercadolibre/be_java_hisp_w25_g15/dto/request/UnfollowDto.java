package com.mercadolibre.be_java_hisp_w25_g15.dto.request;

import jakarta.validation.constraints.Positive;

public record UnfollowDto(
        @Positive(message = "El user_id debe ser un número entero positivo") int userId,
        @Positive(message = "El user_id debe ser un número entero positivo") int unfollowUserId
){
}