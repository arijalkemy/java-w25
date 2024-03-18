package com.bootcamp.ejercicio_consultas_HQL.controller;

import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.ResSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.ResponseDTO;
import com.bootcamp.ejercicio_consultas_HQL.service.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {
    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createSiniestro(@RequestBody ReqSiniestroDTO siniestroDTO) {
        return ResponseEntity.ok((siniestroService.create(siniestroDTO)));
    }
    @GetMapping()
    public ResponseEntity<List<ResSiniestroDTO>> getAllSiniestros() {
        return ResponseEntity.ok(siniestroService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResSiniestroDTO> getSiniestroById(@PathVariable Long id) {
        return ResponseEntity.ok(siniestroService.getById(id));
    }
}
