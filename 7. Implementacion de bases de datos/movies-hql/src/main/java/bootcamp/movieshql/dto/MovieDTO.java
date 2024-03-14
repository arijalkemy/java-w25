package bootcamp.movieshql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MovieDTO {

    Integer id;

    String title;

    Double rating;

    Integer awards;

    LocalDate releaseDate;

    Integer length;

}
