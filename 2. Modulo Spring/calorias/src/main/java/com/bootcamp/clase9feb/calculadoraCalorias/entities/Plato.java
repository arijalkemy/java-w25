package com.bootcamp.clase9feb.calculadoraCalorias.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plato {
    String name;
    List<HashMap<Alimento, Integer>> ingredients;
    // cada elemento son 100g
}
