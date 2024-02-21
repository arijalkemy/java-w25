package com.ConcesionarioAutos.demo.controller;

import com.ConcesionarioAutos.demo.dto.vehiclesDTO;
import com.ConcesionarioAutos.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public void addVehicle(@RequestBody vehiclesDTO vehicle) {
        vehicleService.addVehicle(vehicle);
    }

    @GetMapping
    public List<vehiclesDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/dates")
    public List<vehiclesDTO> getVehiclesByManufactureDate(@RequestParam("since") Date since, @RequestParam("to") Date to) {
        return vehicleService.getVehiclesByManufactureDate(since, to);
    }

    @GetMapping("/prices")
    public List<vehiclesDTO> getVehiclesByPrice(@RequestParam("since") Double since, @RequestParam("to") Double to) {
        return vehicleService.getVehiclesByPrice(since, to);
    }

    @GetMapping("/{id}")
    public vehiclesDTO getVehicleById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }

}