package grupo_7.sprint_1.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record BuyerDto(
        @NotNull(message = "El  id no puede estar vacío.")
        @Positive(message = "El id debe ser mayor a cero")
        int userId,
        @Max(value = 15,message = "El nombre no puede tener mas de 15 caracteres")
        String userName,
        List<SellerListDto> sellerList
) {
}
