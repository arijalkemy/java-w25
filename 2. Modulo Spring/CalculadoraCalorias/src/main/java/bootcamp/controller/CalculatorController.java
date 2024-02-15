package bootcamp.controller;

import bootcamp.dto.FoodDTO;
import bootcamp.dto.PlateDTO;
import bootcamp.service.FoodServiceImp;
import bootcamp.service.IFoodService;
import bootcamp.service.IPlateService;
import bootcamp.service.PlateServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")

public class CalculatorController {

    private IFoodService foodService;
    private IPlateService plateService;

    public CalculatorController(FoodServiceImp foodService, PlateServiceImp plateService){
        this.foodService = foodService;
        this.plateService = plateService;
    }

    @GetMapping("")
    public ResponseEntity<List<FoodDTO>> getAll(){

        return new ResponseEntity<>(foodService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<PlateDTO> getAll(@PathVariable String name){

        return new ResponseEntity<>(plateService.cookPlate(plateService.findPlateByName(name)), HttpStatus.OK);
    }
}
