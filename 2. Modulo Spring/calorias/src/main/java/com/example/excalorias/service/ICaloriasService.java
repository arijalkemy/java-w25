package com.example.excalorias.service;

import com.example.excalorias.model.Ingrediente;

import java.util.List;
import java.util.Map;

public interface ICaloriasService {


    Map<String, Integer> getCalorias(List<String> nombresDePlatos);

    Map<String, List<Ingrediente>> getIngredientes(List<String> nombresDePlatos);

    Map<String, Ingrediente> getIngredienteMaxCalorias(List<String> nombresDePlatos);
}
