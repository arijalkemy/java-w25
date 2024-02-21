package com.springlh.ejercicios0902.controller;

import com.springlh.ejercicios0902.dto.PlateCaloriesDTO;
import com.springlh.ejercicios0902.dto.PlateDTO;
import com.springlh.ejercicios0902.dto.PlateIngredientDTO;
import com.springlh.ejercicios0902.dto.*;
import com.springlh.ejercicios0902.service.PlateService;
import com.springlh.ejercicios0902.service.PlateServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class PlateController {

    private PlateService plateService;
    public PlateController(PlateServiceImp plateService) {
        this.plateService = plateService;
    }

    //@GetMapping("/plates")
    //public List<Plate> findAll() {
    //    return plateService.findAll();
    //}

    @GetMapping("/ingredientsList")
    public ResponseEntity<PlateDTO> findByNameAndWeight(@RequestParam String name,
                                                        @RequestParam Integer weight) {
        return ResponseEntity.ok()
                .body(plateService.findByNameAndWeight(name, weight));
    }

    @GetMapping("/things")
    public ResponseEntity<List<PlateDTO>> getThings(@RequestParam List<String> names) {
        return ResponseEntity.ok()
                .body(plateService.findPlatesByNames(names));
    }

    @GetMapping("/totalCalorias")
    public ResponseEntity<PlateCaloriesDTO> findCaloriesByNameAndWeight(@RequestParam String name,
                                                                        @RequestParam Integer weight) {
        return ResponseEntity.ok()
                .body(plateService.findCaloriesByNameAndWeight(name, weight));

    }

    @GetMapping("/caloriesIngredient")
    public ResponseEntity<PlateIngredientDTO> findMostCaloriesIngredientByNameAndWeight(@RequestParam String name,
                                                                                        @RequestParam Integer weight) {
        return ResponseEntity.ok()
                .body(plateService.findMostCaloriesIngredientByPlate(name, weight));

    }

}
