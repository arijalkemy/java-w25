package com.example.excalorias.controller;

import com.example.excalorias.model.Ingrediente;
import com.example.excalorias.service.ICaloriasService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/calculadora-calorias")
public class CaloriasController {

    private final ICaloriasService caloriasService;

    @GetMapping("/calorias-por-plato/{nombresDePlatos}")
    public Map<String, Integer> getCaloriasPorPlato(@PathVariable List<String> nombresDePlatos){
        return caloriasService.getCalorias(nombresDePlatos);

    }
    @GetMapping("/ingredientes-por-plato/{nombresDePlatos}")
    public Map<String, List<Ingrediente>> getIngredientesPorPlato(@PathVariable List<String> nombresDePlatos){
        return caloriasService.getIngredientes(nombresDePlatos);
    }

    @GetMapping("/ingrediente-max-calorias/{nombresDePlatos}")
    public Map<String, Ingrediente> getIngredienteMaxCalorias(@PathVariable List<String> nombresDePlatos){
        return caloriasService.getIngredienteMaxCalorias(nombresDePlatos);
    }
}
