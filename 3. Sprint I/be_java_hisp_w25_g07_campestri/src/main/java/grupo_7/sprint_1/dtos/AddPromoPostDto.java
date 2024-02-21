package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record AddPromoPostDto(
        @JsonProperty("user_id") @NonNull Integer userId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @JsonProperty("date") @NonNull LocalDate date,
        @JsonProperty("product") @NonNull ProductDto product,
        @JsonProperty("category") @NonNull Integer category,
        @JsonProperty("price") @NonNull Double price,
        @JsonProperty("has_promo") @NonNull Boolean hasPromo,
        @JsonProperty("discount") @NonNull Double discount

) {
}
