package PersonajeStarWars.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Personaje {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("mass")
    private Integer mass;
    @JsonProperty("hair_color")
    private String hair_color;
    @JsonProperty("skin_color")
    private String skin_color;
    @JsonProperty("eye_color")
    private String eye_color;
    @JsonProperty("birth_year")
    private String birth_year;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;

}
