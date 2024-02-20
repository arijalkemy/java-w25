package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

import java.time.LocalDate;

public record AddPromoPostDto(
        @JsonProperty("user_id") @NonNull Integer userId,
        @JsonProperty("date") @NonNull LocalDate date,
        @JsonProperty("product") @NonNull ProductDto product,
        @JsonProperty("category") @NonNull Integer category,
        @JsonProperty("price") @NonNull Double price,
        @JsonProperty("has_promo") @NonNull Boolean hasPromo,
        @JsonProperty("discount") @NonNull Double discount

) {
}
