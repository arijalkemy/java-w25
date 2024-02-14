package com.calorias.SpringInyeccion.controller;

import com.calorias.SpringInyeccion.DTO.ComidaDTO;
import com.calorias.SpringInyeccion.service.ComidaServiceImpl;
import com.calorias.SpringInyeccion.service.IComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    IComidaService comidaService;

    @GetMapping("/obtener-ingredientes")
    public ResponseEntity<ComidaDTO> obtenerIngredientes(@RequestParam List<String> platos){
        return ResponseEntity.ok()
                .body(comidaService.obtenerIngredientes(platos));
    }
}
