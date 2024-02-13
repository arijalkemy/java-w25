package org.starwars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/*Del personaje, se desea ver todos los atributos menos hairColor, skinColor, eyeColor y birthYear.*/
@AllArgsConstructor
@Data
public class PersonajeDTO {
    public String name;
    public double height;
    public double mass;
    public String gender;
    public String homeworld;
    public String species;
}
