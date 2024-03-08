package com.example.starwars.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personaje {
    String name;
    String height;
    String mass;
    String birthYear;

    String hairColor;
    String eyeColor;
    String skinColor;
    String gender;
    String homeWorld;
    String species;
}
