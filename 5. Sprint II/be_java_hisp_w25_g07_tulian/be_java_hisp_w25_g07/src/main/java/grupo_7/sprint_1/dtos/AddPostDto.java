package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record AddPostDto(

        @JsonProperty("user_id")
        @NotNull(message = "El  id no puede estar vacío.")
        Integer userId,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @JsonProperty("date")
        @NotNull(message = "La fecha no puede estar vacía.")
        LocalDate date,

        @JsonProperty("product")
        @NotNull(message = "El producto no puede estar vacío")
        @Valid
        ProductDto product,

        @JsonProperty("category")
        @NotNull(message = "El campo no puede estar vacío.")
        Integer category,

        @JsonProperty("price")
        @NotNull(message = "El campo no puede estar vacío.")
        @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
        Double price

) {
}
