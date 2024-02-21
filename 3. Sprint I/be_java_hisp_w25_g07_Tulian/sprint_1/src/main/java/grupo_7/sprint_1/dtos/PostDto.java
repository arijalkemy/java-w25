package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record PostDto(
        ProductDto product,
        Integer category,
        Double price,
        boolean has_promo,
        Double discount,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate date
) {
    public LocalDate getDate() {
        return this.date;
    }
}
