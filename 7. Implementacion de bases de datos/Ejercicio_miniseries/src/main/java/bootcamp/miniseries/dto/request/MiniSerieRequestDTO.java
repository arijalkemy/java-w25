package bootcamp.miniseries.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MiniSerieRequestDTO {

    String name;
    Double rating;
    @JsonProperty("amount_of_awards")
    int amountOfAwards;

}
