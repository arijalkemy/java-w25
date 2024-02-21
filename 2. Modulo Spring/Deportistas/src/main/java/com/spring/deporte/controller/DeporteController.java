package com.spring.deporte.controller;

import com.spring.deporte.domain.Deporte;
import com.spring.deporte.dto.DeporteDTO;
import com.spring.deporte.mapper.DeporteMapper;
import com.spring.deporte.service.DeporteService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/deportes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeporteController {

    DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> todosDeportes(){

        return ResponseEntity.ok()
                            .body(DeporteMapper.getInstances(this.deporteService.todosLosDeportes()));
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<DeporteDTO> deportesPorNombre(@PathVariable String nombre){
        Optional<Deporte> deporte = this.deporteService.buscarPorNombre(nombre);
        DeporteDTO response =  (deporte.isPresent()) ? DeporteMapper.getInstance(deporte.get()) :  DeporteDTO.builder().build();

        return ResponseEntity.ok()
                .body(response);
    }

}
