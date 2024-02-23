package com.bootcamp.ejercicio_concesionaria.controller;

import com.bootcamp.ejercicio_concesionaria.dto.request.RequestCarDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;
import com.bootcamp.ejercicio_concesionaria.service.ICarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
