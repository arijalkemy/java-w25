package org.bootcamp.segurosautos.controller;

import org.bootcamp.segurosautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService service;

    @GetMapping("/patents")
    public ResponseEntity<?> getVehiclePatents() {
        return ResponseEntity.ok(service.getPatentsFromVehicles());
    }

    @GetMapping("/patentsAndBrands")
    public ResponseEntity<?> getPatentsAndBrands() {
        return ResponseEntity.ok(service.getPatentsAndBrandsOrderByYear());
    }

    @GetMapping("/patentsFourWheels")
    public ResponseEntity<List<String>> getPatentsWithFourWheels(){
        return ResponseEntity.ok(service.getPatentsWithFourWheelsAndCurrentYear());
    }

    @GetMapping("/totaled")
    public ResponseEntity<?> getTotaledVehicles() {
        return ResponseEntity.ok(service.getVehiclesWithExpensiveAccident());
    }

    @GetMapping("/totaledAccumulativeCosts")
    public ResponseEntity<?> getTotaledAccumulativeCosts() {
        return ResponseEntity.ok(service.getAccumulativeAccidents());
    }



}
