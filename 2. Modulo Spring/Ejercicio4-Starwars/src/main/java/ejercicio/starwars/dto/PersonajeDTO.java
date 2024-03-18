package ejercicio.starwars.dto;


import ejercicio.starwars.entity.Personaje;
import lombok.*;
import lombok.extern.flogger.Flogger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {
    private String name;
    private int heigth;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(Personaje personaje){
        this.name = personaje.getName();
        this.heigth = personaje.getHeigth();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeworld = personaje.getHomeworld();
        this.species = personaje.getSpecies();
    }

}
