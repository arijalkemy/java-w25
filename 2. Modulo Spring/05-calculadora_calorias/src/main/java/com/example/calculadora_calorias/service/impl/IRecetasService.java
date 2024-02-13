package com.example.calculadora_calorias.service.impl;

import com.example.calculadora_calorias.dto.CaloriasRecetaDto;
import com.example.calculadora_calorias.dto.PlatosWrapperDto;
import com.example.calculadora_calorias.dto.RecetaIngredientesCalorias;
import com.example.calculadora_calorias.entity.Receta;

import java.util.List;
import java.util.Optional;

public interface IRecetasService {

    CaloriasRecetaDto caloriasPlato(String plato);
    List<RecetaIngredientesCalorias>detallesRecetas(PlatosWrapperDto platos);

    RecetaIngredientesCalorias getDetalleReceta(String plato);
    String ingredienteMasCalorias(String receta);

    Optional<Receta> findReceta(String plato);




}
