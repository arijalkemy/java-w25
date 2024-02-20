package com.example.starWars.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;


    @JsonSetter("height")
    public void setHeight(String height) {
        try {
            this.height = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            this.height = 0;
        }
    }

    @JsonSetter("mass")
    public void setMass(String mass) {
        try {
            this.mass = Integer.parseInt(mass);
        } catch (NumberFormatException e) {
            this.mass = 0;
        }
    }

}
