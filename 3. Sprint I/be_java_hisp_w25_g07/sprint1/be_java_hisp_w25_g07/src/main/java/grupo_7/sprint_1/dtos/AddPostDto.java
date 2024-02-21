package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record AddPostDto(
        @JsonProperty("user_id") Integer userId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @JsonProperty("date") LocalDate date,
        @JsonProperty("product") ProductDto product,
        @JsonProperty("category") Integer category,
        @JsonProperty("price") Double price

) {
}
