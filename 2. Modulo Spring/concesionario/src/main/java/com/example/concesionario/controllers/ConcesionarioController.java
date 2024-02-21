package com.example.concesionario.controllers;

import com.example.concesionario.dto.AutomovilDto;
import com.example.concesionario.entities.Automovil;
import com.example.concesionario.services.IConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class ConcesionarioController {

    @Autowired
    private IConcesionarioService service;

    @PostMapping
    public ResponseEntity<AutomovilDto> addAutomovil(@RequestBody Automovil automovil){
        return new ResponseEntity<>(this.service.addAutomovil(automovil), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AutomovilDto>> getAutomoviles(){
        return new ResponseEntity<>(this.service.getAllAutomoviles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getAutomovilesByDate(@RequestParam String since, @RequestParam String to){
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date initialDate;
        Date finalDate;

        try{
            initialDate = formatDate.parse(since);
            finalDate = formatDate.parse(to);
        }catch (ParseException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de fecha incorrecta. Usar yyyy-mm-dd");
        }

        return new ResponseEntity<>(this.service.getAllAutomovilesByDate(initialDate, finalDate), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<AutomovilDto>> getAutomovilesByPrice(@RequestParam double since, @RequestParam double to){
        return new ResponseEntity<>(this.service.getAllAutomovilesByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomovilDto> getAutomovil(@PathVariable int id){
        return new ResponseEntity<>(this.service.getAutomovil(id), HttpStatus.OK);
    }
}
