package bootcamp.springejerciciospracticosp2vivo.controller;

import bootcamp.springejerciciospracticosp2vivo.dto.*;
import bootcamp.springejerciciospracticosp2vivo.exception.IngredientNotFoundException;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateNotFoundException;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateWithNoValidIngredientsException;
import bootcamp.springejerciciospracticosp2vivo.service.IPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("plates")
public class PlateController {

    @Autowired
    private IPlateService plateService;

    @GetMapping("/{name}/weight/{weight}")
    public ResponseEntity<PlateTotalCaloriesDto> getPlateTotalCalories(
            @PathVariable String name,
            @PathVariable Double weight
    ) {
        try {
            return ResponseEntity.ok(plateService.getTotalCalories(name, weight));
        } catch (IngredientNotFoundException | PlateNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{name}/ingredients")
    public ResponseEntity<CaloriesPerIngredientDto> getPlateCaloriesPerIngredient(
            @PathVariable String name
    ) {
        try {
            return ResponseEntity.ok(plateService.getCaloriesPerIngredient(name));
        } catch (IngredientNotFoundException | PlateNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{name}/ingredient-with-most-calories")
    public ResponseEntity<IngredientDto> getMostCaloricalIngredient(
            @PathVariable String name
    ) {
        try {
            return ResponseEntity.ok(plateService.getMostCaloricalIngredient(name));
        } catch (IngredientNotFoundException | PlateNotFoundException | PlateWithNoValidIngredientsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<CaloriesPerPlateDto> getCaloriesPerPlate(
            @RequestParam List<String> plateNames,
            @RequestParam List<Double> plateWeights
    ) {
        try {
            if (plateNames.size() != plateWeights.size()) return ResponseEntity.badRequest().build();

            List<PlateDto> plates = new ArrayList<>();
            for (int i = 0; i < plateNames.size(); i++) {
                plates.add(new PlateDto(plateNames.get(i), plateWeights.get(i)));
            }
            return ResponseEntity.ok(plateService.getCaloriesPerPlate(plates));
        } catch (IngredientNotFoundException | PlateNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
