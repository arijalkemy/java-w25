package com.springboot.concesionariaautos.controller;

import com.springboot.concesionariaautos.dto.CarDTO;
import com.springboot.concesionariaautos.service.IDealershipService;
import com.springboot.concesionariaautos.service.impl.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/vehicles")
public class DealershipController {
    private final IDealershipService dealershipService;
    @Autowired
    public DealershipController(DealershipServiceImpl dealershipService) {
        this.dealershipService = dealershipService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createCar(@RequestBody CarDTO car) {
        try {
            dealershipService.createCar(car);
            return new ResponseEntity<>("The car was successfully created ✅", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create the car: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CarDTO>> cars() {
        return new ResponseEntity<>(dealershipService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarDTO>> getCarsByDates(@RequestParam String dateSince, @RequestParam String dateTo) {
        return new ResponseEntity<>(dealershipService.getCarsByDates(dateSince, dateTo), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarDTO>> getCarsByPrice(@RequestParam String priceSince, @RequestParam String priceTo) {
        return new ResponseEntity<>(dealershipService.getCarsByPrices(priceSince, priceTo), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CarDTO>> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(dealershipService.getCarById(id), HttpStatus.OK);
    }
}
