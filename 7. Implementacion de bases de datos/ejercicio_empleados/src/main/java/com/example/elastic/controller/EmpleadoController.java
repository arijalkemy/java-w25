package com.example.elastic.controller;

import com.example.elastic.dto.EmpleadoDTO;
import com.example.elastic.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private IEmpleadoService IEmpleadoService;

    @GetMapping("/empleado")
    public ResponseEntity<List<EmpleadoDTO>> list() {
        return ResponseEntity.ok().body(IEmpleadoService.list());

    }

    @PostMapping("/empleado")
    public ResponseEntity<EmpleadoDTO> save(@RequestBody EmpleadoDTO empleadoDTO) {
        return ResponseEntity.ok().body(IEmpleadoService.save(empleadoDTO));

    }


}
