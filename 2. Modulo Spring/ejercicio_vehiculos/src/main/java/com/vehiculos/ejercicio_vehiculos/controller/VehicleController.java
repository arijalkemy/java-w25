package com.vehiculos.ejercicio_vehiculos.controller;

import com.vehiculos.ejercicio_vehiculos.dto.VehicleDto;
import com.vehiculos.ejercicio_vehiculos.service.VehicleServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    VehicleServiceImpl vehicleService;

    // Get all vehicles
    @GetMapping()
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    // Create new vehicle
    @PostMapping()
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto), HttpStatus.CREATED);
    }

    // Get by color and year
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getByColorAndYear(@PathVariable String color, @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.searchVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

    // Get by brand and range years
    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getByBrandAndRangeYears(@PathVariable String brand, @PathVariable Integer start_year, @PathVariable Integer end_year){
        return new ResponseEntity<>(vehicleService.searchVehiclesByBrandAndRangeYear(brand, start_year, end_year), HttpStatus.OK);
    }

    // Get speed average by brand
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getSpeedAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    // Create multi vehicles
    @PostMapping("/batch")
    public ResponseEntity<?> saveVehicles(@RequestBody List<VehicleDto> vehicleDtoList){
        return new ResponseEntity<>("Add vehicles", HttpStatus.CREATED);
    }

    // Modify max speed from vehicle
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestBody String max_speed){
        return new ResponseEntity<>("Modify speed", HttpStatus.OK);
    }

    // Delete vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    // Get vehicles by dimensions
    @GetMapping("/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>("Range dimensions", HttpStatus.OK);
    }

    // Get vehicles by weight range
    @GetMapping("/weight")
    public ResponseEntity<?> getVehiclesByWeight(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>("Range Weight", HttpStatus.OK);
    }
}
