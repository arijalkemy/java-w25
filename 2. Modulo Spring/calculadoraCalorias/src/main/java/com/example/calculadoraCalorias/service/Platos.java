package com.example.calculadoraCalorias.service;

import com.example.calculadoraCalorias.dto.PlatoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Platos {
    List<PlatoDTO> mostrasIngredientesPlato(String nombrePlato, int pesoEnGramo);
}
