package com.calorias.SpringInyeccion.DTO;


import com.calorias.SpringInyeccion.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComidaDTO {

    private Integer caloriasTotales;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMaxColorias;
}
