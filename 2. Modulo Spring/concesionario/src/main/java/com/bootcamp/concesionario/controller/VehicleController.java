package com.bootcamp.concesionario.controller;

import com.bootcamp.concesionario.dto.MessageDto;
import com.bootcamp.concesionario.dto.VehicleDto;
import com.bootcamp.concesionario.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Data
@RestController
@RequestMapping("/v1/api")
public class VehicleController {

    private VehicleService vehicleService;

    public  VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<MessageDto> addNewVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.FOUND);
    }
    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehicleDto>> getAllVehicles(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByProductionDate(since,to), HttpStatus.FOUND);
    }
    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByPrice(@RequestParam double since, @RequestParam double to){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByPrice(since,to), HttpStatus.FOUND);
    }
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> getByIdVehicle(@PathVariable int id){
        return new ResponseEntity<>(vehicleService.getByIdVehicle(id), HttpStatus.FOUND);
    }

}
