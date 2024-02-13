package com.daquito.concesionarioautosspring.controller;

import com.daquito.concesionarioautosspring.entity.Vehicle;
import com.daquito.concesionarioautosspring.services.VehicleService;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("v1/api/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("v1/api/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.OK);
    }

    //  dates
    @GetMapping("v1/api/vehicles/dates")
    public ResponseEntity<List<Vehicle>> getVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return new ResponseEntity<>(vehicleService.getVehicleByDates(since, to), HttpStatus.OK);
    }

    //  prices
    @GetMapping("v1/api/vehicles/price")
    public ResponseEntity<List<Vehicle>> getVehiclesByPrice(@RequestParam double since, @RequestParam double to){
        return new ResponseEntity<>(vehicleService.getVehicleByPrice(since, to), HttpStatus.OK);
    }

    
    // getId
    @GetMapping("v1/api/vehicles/{index}")
    public ResponseEntity<Vehicle> getVehicleByIndex(@PathVariable Integer index){

        return new ResponseEntity<>(vehicleService.getVehicle(index), HttpStatus.OK);
    }
}
