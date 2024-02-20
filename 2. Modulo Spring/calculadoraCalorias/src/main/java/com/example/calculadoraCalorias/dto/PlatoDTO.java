package com.example.calculadoraCalorias.dto;

import com.example.calculadoraCalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDTO {

    private int cantidadTotalCalorias;
    private List<Ingrediente> ingredienteYCalorias;
    private String ingredienteConMayorCalorias;

}
