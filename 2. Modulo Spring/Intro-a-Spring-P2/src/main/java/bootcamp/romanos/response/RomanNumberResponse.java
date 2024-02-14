package bootcamp.romanos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RomanNumberResponse {

    Integer originalNumber;
    String romanNumber;

}
