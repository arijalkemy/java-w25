package com.example.calculadora_calorias.controller;

import com.example.calculadora_calorias.dto.CaloriasRecetaDto;
import com.example.calculadora_calorias.dto.PlatosWrapperDto;
import com.example.calculadora_calorias.dto.RecetaIngredientesCalorias;
import com.example.calculadora_calorias.service.impl.IRecetasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    private IRecetasService recetasService;

    public MenuController(IRecetasService recetasService) {
        this.recetasService = recetasService;
    }


    @GetMapping("/calorias")
    public ResponseEntity<CaloriasRecetaDto> caloriasPlato(@RequestParam String plato){

        return new ResponseEntity<CaloriasRecetaDto>(recetasService.caloriasPlato(plato), HttpStatus.OK);

    }

    @GetMapping("/caloriasdetalle")
    public ResponseEntity<RecetaIngredientesCalorias> detalleReceta(@RequestParam String plato){

        return new ResponseEntity<RecetaIngredientesCalorias>(recetasService.getDetalleReceta(plato), HttpStatus.OK);

    }

    @GetMapping("/ingredienteMasCalorico")
    public ResponseEntity<String> ingredienteMasCalorico(@RequestParam String plato){

        return new ResponseEntity<String>(recetasService.ingredienteMasCalorias(plato), HttpStatus.OK);

    }

    @GetMapping("/detallesRecetas")
    public ResponseEntity<List<RecetaIngredientesCalorias>> detallesRecetas(@RequestBody PlatosWrapperDto platos){

        return new ResponseEntity<List<RecetaIngredientesCalorias>>(recetasService.detallesRecetas(platos), HttpStatus.OK);

    }


}
