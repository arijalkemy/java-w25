package com.bootcamp.Calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientexPlato {
    private Ingrediente ingrediente;
    private int peso;
    public int getCaloriasTotales(){
        return this.ingrediente.CalcularCalorias(peso);
    }

}
