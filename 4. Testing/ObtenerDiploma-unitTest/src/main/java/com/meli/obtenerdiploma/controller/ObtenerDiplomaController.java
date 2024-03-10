package com.meli.obtenerdiploma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;

@RestController
public class ObtenerDiplomaController {

    final IObtenerDiplomaService service;

    ObtenerDiplomaController(IObtenerDiplomaService service) {
        this.service = service;
    }

    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}
