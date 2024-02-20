package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.*;

import java.time.LocalDate;

public record AddPostDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("date") LocalDate date,
        @JsonProperty("product") ProductDto product,
        @JsonProperty("category") Integer category,
        @JsonProperty("price") Double price

) {
}
