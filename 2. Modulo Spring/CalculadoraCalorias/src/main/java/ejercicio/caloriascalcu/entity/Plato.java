package ejercicio.caloriascalcu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private HashMap<Ingrediente, Double> cantidadesIngredientes;
    //Harina, 100
    //private Double cantidadGramos;

}
