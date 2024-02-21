package grupo_7.sprint_1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record PostDto(
        ProductDto product,
        Integer category,
        Double price,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate date,
        Boolean hasPromo,
        Double discount
) {
    public LocalDate getDate() {
        return this.date;
    }
}
