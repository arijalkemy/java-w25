package com.spring.deporte.controller;

import com.spring.deporte.dto.DeporteDTO;
import com.spring.deporte.service.DeporteService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/deportes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeporteController {

    DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> todosDeportes(){

        return ResponseEntity.ok()
                            .body(this.deporteService.todosLosDeportes());
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<DeporteDTO> deportesPorNombre(@RequestParam(name = "nombre") String nombre){
        return ResponseEntity.ok()
                .body(this.deporteService.buscarPorNombre(nombre));
    }
}