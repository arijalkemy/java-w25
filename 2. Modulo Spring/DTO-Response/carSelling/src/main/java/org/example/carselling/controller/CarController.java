package org.example.carselling.controller;

import org.example.carselling.dto.CarDTO;
import org.example.carselling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/")
    public void createCar(@RequestBody CarDTO carDTO){
        carService.createCar(carDTO);
    }

    @GetMapping("/")
    public List<CarDTO> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/dates")
    public List<CarDTO> getCarsByDate(@RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") Date since, @RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") Date to){
        return carService.getCarsByDate(since, to);
    }

    @GetMapping("/prices")
    public List<CarDTO> getCarsByPrices(@RequestParam Double since, @RequestParam Double to){
        return carService.getCarsByPrice(since, to);
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable Integer id){
        return carService.getCarById(id);
    }
}
