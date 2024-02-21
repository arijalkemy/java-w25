package grupo_7.sprint_1.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public record PromoPostDto(
        ProductDto product,
        Integer category,
        Double price,
        LocalDate date,
        Boolean hasPromo,
        Double discount
) {
    public LocalDate getDate() {
        return this.date;
    }
}
