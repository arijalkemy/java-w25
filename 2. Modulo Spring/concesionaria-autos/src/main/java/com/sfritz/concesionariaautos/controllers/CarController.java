package com.sfritz.concesionariaautos.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sfritz.concesionariaautos.dtos.requests.RequestCarDto;
import com.sfritz.concesionariaautos.dtos.response.FullResponseCarDto;
import com.sfritz.concesionariaautos.dtos.response.ResponseCarDto;
import com.sfritz.concesionariaautos.services.CarService;
import com.sfritz.concesionariaautos.services.ICarService;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    
    private ICarService service;

    public CarController(CarService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<String> createVehicle(@RequestBody RequestCarDto request){
        service.createVehicle(request);
        return new ResponseEntity<>("Vehiculo dado de alta.", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponseCarDto>> getAllVehicles(){
        return new ResponseEntity<>(service.getAllVehicles(), HttpStatus.CREATED);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<FullResponseCarDto>> getVehiclesFromManufacturingDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date since, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to){
        return new ResponseEntity<>(service.getVehiclesFromManufacturingDate(since, to), HttpStatus.CREATED);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<FullResponseCarDto>> getVehiclesFromPrices(@RequestParam Double since, @RequestParam Double to){
        return new ResponseEntity<>(service.getVehiclesFromPrices(since, to), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FullResponseCarDto> getVehicleById(@PathVariable Long id){
        return new ResponseEntity<>(service.getVehicleById(id), HttpStatus.CREATED);
    }
}
