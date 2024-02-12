package com.bootcamp.ejercicio_concesionaria.controller;

import com.bootcamp.ejercicio_concesionaria.dto.request.VehicleDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.VehicleWithoutServiceDTO;
import com.bootcamp.ejercicio_concesionaria.service.IVehicleService;
import com.bootcamp.ejercicio_concesionaria.service.VehicleServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class ConcesionariaController {
    IVehicleService vehicleService;
    public ConcesionariaController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }
    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        System.out.println(vehicleDTO);
        try {
            int idRegistrado = vehicleService.addVehicle(vehicleDTO);
            return ResponseEntity.ok(idRegistrado);
        }catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());

        }

    }

    @GetMapping
    public ResponseEntity<List<VehicleWithoutServiceDTO>> getVehiculos( ){
        List<VehicleWithoutServiceDTO> vehicles = vehicleService.getVehicles();
       if( vehicles.isEmpty()){
    return new ResponseEntity<>(vehicles, HttpStatus.NO_CONTENT);
        }else{
           return  new ResponseEntity<>(vehicles, HttpStatus.OK);
       }
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleWithoutServiceDTO> getVehiculoById(@PathVariable int id){
        VehicleWithoutServiceDTO vehicleWithoutServiceDTO = vehicleService.getVehicleById(id);
        if (vehicleWithoutServiceDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>(vehicleWithoutServiceDTO, HttpStatus.OK);

    }}

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleWithoutServiceDTO>> getVehicleByDate(@RequestParam String since, @RequestParam String to){
        List<VehicleWithoutServiceDTO> vehicles = this.vehicleService.getVehicleByDate(LocalDate.parse(since), LocalDate.parse(to));
        if (vehicles.isEmpty()){
            return new ResponseEntity<>(vehicles, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }

    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleWithoutServiceDTO>> getVehicleByPrice(@RequestParam int since, @RequestParam int to){
        List<VehicleWithoutServiceDTO> vehicles = this.vehicleService.getVehicleByPrice(since, to);
        if (vehicles.isEmpty()){
            return new ResponseEntity<>(vehicles, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
    }
}
