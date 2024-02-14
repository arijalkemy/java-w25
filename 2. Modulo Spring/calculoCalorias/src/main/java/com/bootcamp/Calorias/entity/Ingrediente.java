package com.bootcamp.Calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;
    public int CalcularCalorias(int gramos){
        return this.calories/100 * gramos;
     }
}
