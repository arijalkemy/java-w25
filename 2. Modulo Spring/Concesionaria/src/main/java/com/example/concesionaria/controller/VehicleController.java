package com.example.concesionaria.controller;

import com.example.concesionaria.dto.request.VehicleDTO;
import com.example.concesionaria.dto.response.CompleteVehicleDTO;
import com.example.concesionaria.dto.response.SaveDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;
import com.example.concesionaria.service.IVehicleService;
import com.example.concesionaria.service.VehicleServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
  private IVehicleService vehicleService;
  public VehicleController(VehicleServiceImp vehicleService) { this.vehicleService = vehicleService; }

  @PostMapping("vehicles")
  ResponseEntity<SaveDTO> save(@RequestBody VehicleDTO vehicle) {
    return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.OK);
  }

  @GetMapping("vehicles")
  ResponseEntity<List<VehicleResponseDTO>> get() {
    return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
  }

//  @GetMapping("vehicles/dates")
//  ResponseEntity<List<VehicleResponseDTO>> getByDate(@RequestParam String since, @RequestParam String to) {
//
//  }
//
//  @GetMapping("vehicles/prices")
//  ResponseEntity<List<VehicleResponseDTO>> getByPrices(@RequestParam int since, @RequestParam int to) {
//
//  }
//
  @GetMapping("vehicles/{id}")
  ResponseEntity<CompleteVehicleDTO> getById(@PathVariable String id) {
    return new ResponseEntity<>(vehicleService.getById(id), HttpStatus.OK);
  }

}
