package grupo_7.sprint_1.dtos;

import java.time.LocalDate;


public record PostDto(
        ProductDto product,
        Integer category,
        Double price,
        LocalDate date
) {
    public LocalDate getDate() {
        return this.date;
    }
}
