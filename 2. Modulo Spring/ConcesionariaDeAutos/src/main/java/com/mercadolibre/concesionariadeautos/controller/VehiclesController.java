package com.mercadolibre.concesionariadeautos.controller;

import com.mercadolibre.concesionariadeautos.dto.*;
import com.mercadolibre.concesionariadeautos.service.IVehicleService;
import com.mercadolibre.concesionariadeautos.service.VehicleServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehiclesController {

    IVehicleService vehicleService;

    public VehiclesController(VehicleServiceImp vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleIdDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleIdDTO response = vehicleService.addVehicle(vehicleDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleWithoutServicesDTO>> getAllVehicles() {
        List<VehicleWithoutServicesDTO> response = vehicleService.getAllVehicles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesBetweenDate(@RequestParam LocalDate since,
                                                                                  @RequestParam LocalDate to) {
        List<VehicleDTO> response = vehicleService.getVehiclesBetweenDate(new DateFilterDTO(since, to));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesBetweenDate(@RequestParam Integer since,
                                                                   @RequestParam Integer to) {
        List<VehicleDTO> response = vehicleService.getVehiclesBetweenPrice(new PriceFilterDTO(since, to));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehiclesBetweenDate(@PathVariable Integer id) {
        VehicleDTO response = vehicleService.getVehicleById(new VehicleIdDTO(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
