package com.example.concesionario.controller;

import com.example.concesionario.dto.VehicleDTO;
import com.example.concesionario.dto.VehicleNoServicesDTO;
import com.example.concesionario.dto.CreateVehicleDTO;
import com.example.concesionario.service.IVehicleService;
import com.example.concesionario.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class Vehicles {
    private final IVehicleService vehicleService;

    @Autowired
    public Vehicles(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createVehicle(@RequestBody CreateVehicleDTO vehicle) {
        vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>("Vehicle created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleNoServicesDTO>> getVehicles() {
        List<VehicleNoServicesDTO> vehicles = vehicleService.getVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleNoServicesDTO>> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        List<VehicleNoServicesDTO> vehicles = vehicleService.getVehiclesByDate(since, to);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleNoServicesDTO>> getVehiclesByPrice(@RequestParam String since, @RequestParam String to) {
        List<VehicleNoServicesDTO> vehicles = vehicleService.getVehiclesByPrice(since, to);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable String id) {
        VehicleDTO vehicle = vehicleService.getVehicleById(id);
        return vehicle != null ? new ResponseEntity<>(vehicle, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}