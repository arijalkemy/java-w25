package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.SpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicles(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto),HttpStatus.CREATED);

    }
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehicles(@PathVariable("color") String color,@PathVariable("year") Integer year){
        return new ResponseEntity<>(vehicleService.filterYearAndColor(year,color),HttpStatus.OK);
    }
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehicles(@PathVariable("brand") String Brand,@PathVariable("start_year") Integer startYear,@PathVariable("end_year") Integer endYear ){
        return new ResponseEntity<>(vehicleService.filterBrandAndBetweenYears(Brand, startYear, endYear),HttpStatus.OK);
    }
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getVehiclesAverageSpeed(@PathVariable("brand") String Brand ){
        return new ResponseEntity<>(vehicleService.averageSpeedToBrand(Brand),HttpStatus.OK);
    }
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addVehicles(@RequestBody List<VehicleDto> vehicles) throws IllegalAccessException {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicles),HttpStatus.CREATED);

    }
    @PutMapping("/vehicles/{id}/update_speed")
    public  ResponseEntity<?> updateSpeddForId(@RequestBody SpeedDto speedDto,@PathVariable("id") Long id) throws IOException {
        return new ResponseEntity<>(vehicleService.updateSpeed(id,speedDto.getSpeed()),HttpStatus.OK);
    }
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deletedvehiclefroId(@PathVariable("id") Long id){
        return new ResponseEntity<>(vehicleService.deletedVehicleId(id),HttpStatus.NO_CONTENT);
    }
}
