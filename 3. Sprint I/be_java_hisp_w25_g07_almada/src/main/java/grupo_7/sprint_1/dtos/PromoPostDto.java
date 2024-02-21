package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate date,
    @JsonProperty("has_promo")
    @NonNull
    Boolean hasPromo,
    @NonNull
    Double discount

){
}
