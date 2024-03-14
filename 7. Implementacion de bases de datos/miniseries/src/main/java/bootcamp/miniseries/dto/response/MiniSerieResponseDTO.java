package bootcamp.miniseries.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MiniSerieResponseDTO {

    Long id;
    String name;
    Double rating;
    int amountOfAwards;

}
