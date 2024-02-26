package com.bootcamp.ejercicio_concesionaria.controller;

import com.bootcamp.ejercicio_concesionaria.dto.request.RequestCarDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;
import com.bootcamp.ejercicio_concesionaria.service.ICarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addCar (@RequestBody RequestCarDTO carDTO){
        carService.addCar(carDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/")
    public ResponseEntity<List<ResponseCarDTO>> getCars (){
        return ResponseEntity.ok()
                .body(carService.getUsedCars());
    }
    @GetMapping("/dates")
    public ResponseEntity<List<ResponseCarDTO>> getCarsBetweenDates (
            @RequestParam("since") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to
    ){
        return ResponseEntity.ok()
                .body(carService.getCarsBetweenDates(since, to));
    }
    @GetMapping("/prices")
    public ResponseEntity<List<ResponseCarDTO>> getCarsBetweenPrices (
            @RequestParam("since") double since,
            @RequestParam("to") double to
    ){
        return ResponseEntity.ok()
                .body(carService.getCarsBetweenPrices(since, to));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCarDTO> getCarById (@PathVariable int id){
        return ResponseEntity.ok()
                .body(carService.getCarById(id));
    }
}
