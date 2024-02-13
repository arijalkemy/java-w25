package dto;

import entity.Personaje;

public class PersonajeDTO {
    private String name;
    private int height;
    private double mass;
    private String gender;
    private String homeWorld;
    private String species;

    private PersonajeDTO(String name, int height, double mass, String gender, String homeWorld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.species = species;
    }

    public static PersonajeDTO fromPersonaje(Personaje personaje){
        return new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getMass() {
        return mass;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public String getSpecies() {
        return species;
    }
}
