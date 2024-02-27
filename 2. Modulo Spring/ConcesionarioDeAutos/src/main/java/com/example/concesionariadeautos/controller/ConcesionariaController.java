package com.example.concesionariadeautos.controller;

import com.example.concesionariadeautos.dto.VehicleDTO;
import com.example.concesionariadeautos.service.IVehicleService;
import com.example.concesionariadeautos.service.VehicleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.concesionariadeautos.entity.Vehicle;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ConcesionariaController {
    IVehicleService vehicleService;
    @Autowired
    public ConcesionariaController(VehicleServiceImp vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDate(@RequestParam("since") String since, @RequestParam("to") String to) {
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByCreatedDate(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrice(@RequestParam("since") String since, @RequestParam("to") String to) {
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByPrice(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable("id") String id) {
        VehicleDTO vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

}
