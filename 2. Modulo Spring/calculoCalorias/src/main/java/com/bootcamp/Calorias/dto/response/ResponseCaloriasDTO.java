package com.bootcamp.Calorias.dto.response;

import com.bootcamp.Calorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseCaloriasDTO {
    private double cantidadCalorias;
    private List<IngredienteDTO> ingredientes;
    private String ingredienteMaximo;
}
