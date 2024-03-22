package com.qatesters.qatesters.controller;

import com.qatesters.qatesters.dto.request.TestcaseDTO;
import com.qatesters.qatesters.service.TestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestcaseController {
    @Autowired
    TestcaseService testcaseService;

    //POST
    ///api/testcases/new
    //Crear un nuevo caso de prueba.
    @PostMapping("/new")
    public ResponseEntity<?> postTestCase(@RequestBody TestcaseDTO testCaseDTO) {
        return new ResponseEntity<>(testcaseService.createTestcase(testCaseDTO), HttpStatus.OK);
    }


    //GET
    ///api/testcases
    //Devolver todos los casos de prueba.
    //GET
    ///api/testcases?last_update=’dd/mm/yyyy’
    //Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.

    @GetMapping("")
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) String last_update) {
        return new ResponseEntity<>(testcaseService.getAll(last_update), HttpStatus.OK);
    }

    //GET
    ///api/testcases/id
    //Devolver un caso de prueba por id.
    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(this.testcaseService.getTestcaseById(id), HttpStatus.OK);
    }


    //PUT
    ///api/testcases/id
    //Actualizar un caso de prueba por id.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestcaseDTO testCaseDTO) {
        return new ResponseEntity<>(testcaseService.updateTestcase(id, testCaseDTO), HttpStatus.OK);

    }


    //DELETE
    ///api/testcases/id
    //Eliminar un tutorial por id.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testcaseService.deleteTestcase(id), HttpStatus.OK);
    }

}
