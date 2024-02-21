package grupo_7.sprint_1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record AddPostDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate date,
        @JsonProperty("product") ProductDto product,
        @JsonProperty("category") Integer category,
        @JsonProperty("price") Double price,
        @JsonProperty("has_promo") Boolean hasPromo,
        @JsonProperty("discount") Double discount

) {
}
