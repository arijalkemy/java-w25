package com.bootcamp.Calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private List<IngredientexPlato> listaIngredientes;
    private int totalCalorias;
    private int peso;
    private String nombre;
    public Plato(List<IngredientexPlato> ingredientes, String nombre){
        this.nombre = nombre;
        this.listaIngredientes = ingredientes;
        this.totalCalorias = ingredientes.stream().mapToInt(IngredientexPlato::getCaloriasTotales).sum();
        this.peso = ingredientes.stream().mapToInt(IngredientexPlato::getPeso).sum();

    }
}
