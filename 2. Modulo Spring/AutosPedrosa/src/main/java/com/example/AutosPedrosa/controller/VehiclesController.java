package com.example.AutosPedrosa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.AutosPedrosa.models.Car;
import com.example.AutosPedrosa.models.CarDTO;
import com.example.AutosPedrosa.services.IVehiclesService;


import java.util.List;


@RestController
@RequestMapping("v1/api/vehicles/")
public class VehiclesController {

    @Autowired
    IVehiclesService vehiclesService;


    @PostMapping
    public boolean addCar(@RequestBody Car car){
        return vehiclesService.addCar(car);
    }

    @GetMapping
    public List<CarDTO> getCars(){
        return vehiclesService.getCars();
    }

    @GetMapping("{id}")
    public Car getCarsBetweenPrices(@PathVariable Long id){
        return vehiclesService.getCar(id);
    }



}
