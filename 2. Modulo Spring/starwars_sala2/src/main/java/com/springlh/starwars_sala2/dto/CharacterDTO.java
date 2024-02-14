package com.springlh.starwars_sala2.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    String name;
    int height;
    int mass;
    String hairColor;
    String skinColor;
    String  eyeColor;
    String birthYear;
    String gender;
    String homeworld;
    String species;
}
