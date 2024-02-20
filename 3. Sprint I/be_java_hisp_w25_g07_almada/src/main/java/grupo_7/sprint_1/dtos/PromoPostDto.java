package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

import java.time.LocalDate;

public record PromoPostDto (
    @JsonProperty("user_id")
    @NonNull
    Integer userId,
    @NonNull
    ProductDto product,
    @NonNull
    Integer category,
    @NonNull
    Double price,
    @NonNull
    LocalDate date,
    @JsonProperty("has_promo")

    @NonNull
    Boolean hasPromo,
    @NonNull
    Double discount

){
}
