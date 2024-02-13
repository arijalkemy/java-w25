package org.example.concesionariaautos.controllers;

import org.example.concesionariaautos.dtos.AutomovilDto;
import org.example.concesionariaautos.models.Automovil;
import org.example.concesionariaautos.services.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLHtmlElement;

@RestController
@RequestMapping("v1/api/vehicles")
public class AutomovilController {

    @Autowired
    AutomovilService automovilService;

    @GetMapping("")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(automovilService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> postVehicles(@RequestBody AutomovilDto auto){
        automovilService.addAutomovil(auto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesByDate(@RequestParam("since") String since, @RequestParam("to") String to){
        return new ResponseEntity<>(automovilService.getByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehicleByPrice(@RequestParam("since") String since, @RequestParam("to") String to){
        return new ResponseEntity<>(automovilService.getByPrice(since, to),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable String id){
        System.out.println(id);
        return new ResponseEntity<>(automovilService.getById(id), HttpStatus.OK);
    }
}
