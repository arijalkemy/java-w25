package bootcamp.dto;

import bootcamp.model.Personaje;

public class PersonajeDTO {
    private String name;
    private Integer height;
    private double mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(Personaje p) {
        this.name = p.getName();
        this.height = p.getHeight();
        this.mass = p.getMass();
        this.gender = p.getGender();
        this.homeworld = p.getHomeworld();
        this.species = p.getSpecies();

    }
}
