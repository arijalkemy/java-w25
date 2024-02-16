package bootcamp.introaspringp2vivo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MorseResponse {

    String originalMorse;
    String translation;

}
