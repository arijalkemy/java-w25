package com.bootcamp.ejercicio_qatester.controller;

import com.bootcamp.ejercicio_qatester.dto.request.TestCaseDTO;
import com.bootcamp.ejercicio_qatester.service.ITestCaseService;
import com.bootcamp.ejercicio_qatester.service.TestCaseServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/testcases")
public class QaTesterController {

    private ITestCaseService testCaseService;

    public QaTesterController(TestCaseServiceImpl testCaseService) {
        this.testCaseService = testCaseService;
    }

    //POST
    ///api/testcases/new
    //Crear un nuevo caso de prueba.
    @PostMapping("/new")
    public ResponseEntity<?> postTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.OK);
    }


    //GET
    ///api/testcases
    //Devolver todos los casos de prueba.
    //GET
    ///api/testcases?last_update=’dd/mm/yyyy’
    //Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.

    @GetMapping("")
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) String last_update) {
        return new ResponseEntity<>(testCaseService.getAll(last_update), HttpStatus.OK);
    }

    //GET
    ///api/testcases/id
    //Devolver un caso de prueba por id.
    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(this.testCaseService.getTestCaseById(id), HttpStatus.OK);
    }


    //PUT
    ///api/testcases/id
    //Actualizar un caso de prueba por id.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO dto) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, dto), HttpStatus.OK);

    }


    //DELETE
    ///api/testcases/id
    //Eliminar un tutorial por id.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }


 

}
