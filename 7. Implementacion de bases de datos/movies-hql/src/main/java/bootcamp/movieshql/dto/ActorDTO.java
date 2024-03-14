package bootcamp.movieshql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ActorDTO {

    Integer id;

    String firstName;

    String lastName;

    Double rating;

}
