package com.concesionario_autos.ejercicio_concesionario_autos.controller;

import com.concesionario_autos.ejercicio_concesionario_autos.dto.CarDTO;
import com.concesionario_autos.ejercicio_concesionario_autos.entity.Car;
import com.concesionario_autos.ejercicio_concesionario_autos.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    @Autowired
    VehiclesService vehiclesService;

    @PostMapping("")
    public Car addCar(@RequestBody Car car){
        return vehiclesService.addCar(car);
    }

    @GetMapping("")
    public List<CarDTO> getAllCars(){
        return vehiclesService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id){
        return vehiclesService.getCarById(id);
    }

    @GetMapping("/dates")
    public List<Car> getCarsBetweenDates(@RequestParam String since, @RequestParam String to) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Date sinceDate=dateFormat.parse(since);
        Date toDate=dateFormat.parse(to);

        return vehiclesService.getCarsBetweenDates(sinceDate, toDate);
    }

    @GetMapping("/prices")
    public List<Car> getCarsBetweenPrices(@RequestParam Double since, @RequestParam Double to){
        return vehiclesService.getItemsBetweenPrices(since, to);
    }
}
