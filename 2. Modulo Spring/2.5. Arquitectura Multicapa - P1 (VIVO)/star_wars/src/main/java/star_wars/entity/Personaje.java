package star_wars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personaje {
    String name;
    Integer height;
    Integer mass;
    @JsonProperty("hair_color")
    String hairColor;
    @JsonProperty("skin_color")
    String skinColor;
    @JsonProperty("eye_color")
    String eyeColor;
    @JsonProperty("birth_year")
    String birthYear;
    String gender;
    String homeworld;
    String species;
}
