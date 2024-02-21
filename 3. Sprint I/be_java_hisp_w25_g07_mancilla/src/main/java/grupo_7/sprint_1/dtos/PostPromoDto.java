package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PostPromoDto(
        @NonNull
        @JsonProperty("user_id") Integer userId,
        @NonNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @JsonProperty("date") LocalDate date,
        @NonNull
        @JsonProperty("product") ProductDto product,
        @NonNull
        @JsonProperty("category") Integer category,
        @NonNull
        @JsonProperty("price") Double price,
        @NonNull
        @JsonProperty("has_promo") Boolean hasPromo,
        @NonNull
        @JsonProperty("discount") Double discount

) {
}