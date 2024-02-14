package com.bootcamp.clase9feb.calculadoraCalorias.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data // Getter, setter, equeals, hasch, etc
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Alimento {
    String name;
    Integer calories;
}
