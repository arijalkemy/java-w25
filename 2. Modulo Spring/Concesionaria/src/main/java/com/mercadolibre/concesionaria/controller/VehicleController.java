package com.mercadolibre.concesionaria.controller;

import com.mercadolibre.concesionaria.dto.Vehicle;
import com.mercadolibre.concesionaria.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(this.vehicleService.getAll(), HttpStatus.OK);
    }

    @PostMapping ("/")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        this.vehicleService.addVehicle(vehicle);
        return  new ResponseEntity<>("new vehicle add", HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Vehicle>> getByPrice(@RequestParam Integer since, @RequestParam Integer to ) {
        return new ResponseEntity<>(this.vehicleService.getByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Vehicle>> getByDates(@RequestParam String since, @RequestParam String to ) {
        return new ResponseEntity<>(this.vehicleService.getByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getByDates(@PathVariable Integer id ) {
        return new ResponseEntity<>(this.vehicleService.getById(id), HttpStatus.OK);
    }
}
