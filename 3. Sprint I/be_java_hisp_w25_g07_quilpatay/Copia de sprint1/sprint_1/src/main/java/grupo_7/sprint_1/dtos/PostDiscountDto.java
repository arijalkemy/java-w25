package grupo_7.sprint_1.dtos;

import java.time.LocalDate;

public record PostDiscountDto(
        ProductDto product,
        Integer category,
        Double price,
        LocalDate date,
        Double discount
) {
}
