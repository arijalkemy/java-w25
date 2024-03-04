package com.example.demo.controller;

import com.example.demo.dto.AutoUsadoDTO;
import com.example.demo.dto.AutoUsadoFullDTO;
import com.example.demo.service.ServiceConcesionario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutosController {
    private final ServiceConcesionario serviceConcesionario;

    public AutosController(ServiceConcesionario serviceConcesionario) {
        this.serviceConcesionario = serviceConcesionario;
    }
    

    @PostMapping("/v1/api/vehicles")
    public ResponseEntity<String> agregarAuto(@RequestBody AutoUsadoDTO auto) {
        System.out.println("---- ENTRO A CONTROLLER Y LLAMO AL SERVICE ----");
        //System.out.println(auto.getBrand());
        serviceConcesionario.agregarAuto(auto);
        return new ResponseEntity<>("Creado", HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles")
    public ResponseEntity<List<AutoUsadoDTO>> traerAutos() {
        return new ResponseEntity<>(serviceConcesionario.traerAutosUsados(), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/dates")
    public ResponseEntity<List<AutoUsadoDTO>> traerAutosPorFechas(@RequestParam String since, String to) {
        return new ResponseEntity<>(serviceConcesionario.traerAutosUsadosPorFechas(since, to), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/prices")
    public ResponseEntity<List<AutoUsadoDTO>> traerAutosPorPrecios(@RequestParam String since, String to) {
        return new ResponseEntity<>(serviceConcesionario.traerAutosPorPrecios(since, to), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/{id}")
    public ResponseEntity<AutoUsadoDTO> traerPorId(@PathVariable String id) {
        return new ResponseEntity<AutoUsadoDTO>(serviceConcesionario.trearPorId(id), HttpStatus.OK);
    }
}
