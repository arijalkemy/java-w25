package com.mercadolibre.concesionaria_de_autos.controller;

import com.mercadolibre.concesionaria_de_autos.dto.request.VehiclePostDto;
import com.mercadolibre.concesionaria_de_autos.dto.response.VehicleResponseDto;
import com.mercadolibre.concesionaria_de_autos.dto.response.VehicleResponseWithoutServicesDto;
import com.mercadolibre.concesionaria_de_autos.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;
    @PostMapping
    public ResponseEntity<VehicleResponseDto> createVehicle(@RequestBody VehiclePostDto vehiclePostDto){
        return ResponseEntity.ok(vehicleService.createVehicle(vehiclePostDto));
    }
    @GetMapping
    public ResponseEntity<List<VehicleResponseWithoutServicesDto>> getAllVehicles(){
        List<VehicleResponseWithoutServicesDto> vehicleResponse = vehicleService.getAllVehicles();
        if(vehicleResponse.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(vehicleResponse);
    }
    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDto>> getAllVehiclesWithinDateRange(
            @RequestParam(name = "since") LocalDate startDate,
            @RequestParam(name = "to") LocalDate endDate
    ) {
        List<VehicleResponseDto> vehicleResponse = vehicleService.getVehiclesByDateRange(startDate, endDate);
        if(vehicleResponse.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(vehicleResponse);
    }
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDto>> getAllVehiclesWithinPriceRange(
            @RequestParam(name = "since") int startPrice,
            @RequestParam(name = "to") int endPrice
    ) {
        List<VehicleResponseDto> vehicleResponse = vehicleService.getVehiclesByPriceRange(startPrice, endPrice);
        if(vehicleResponse.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(vehicleResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getVehicle(@PathVariable Long id){
        return ResponseEntity.of(vehicleService.getVehicle(id));
    }
}
