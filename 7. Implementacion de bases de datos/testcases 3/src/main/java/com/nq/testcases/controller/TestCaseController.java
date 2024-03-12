package com.nq.testcases.controller;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseIdDTO;
import com.nq.testcases.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final TestService testService;

    public TestCaseController(TestService testService) {
        this.testService = testService;
    }

    //Crear un nuevo caso de prueba.
    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO t) {
        return ResponseEntity.ok(testService.createTestCase(t));
    }

    //Devolver un caso de prueba por id.
    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testService.getTestCaseById(id));
    }

    //Actualizar un caso de prueba por id.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id,
                                            @RequestBody TestCaseRequestDTO t) {
        return ResponseEntity.ok(testService.updateTestCase(id, t));
    }

    //Eliminar un tutorial por id.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCaseById(@PathVariable Long id) {
        this.testService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
    @GetMapping("")
    public ResponseEntity<List<TestCaseResponseIdDTO>> getTestCases(@RequestParam(name = "last_update", required = false) LocalDate lastUpdate) {
        if (lastUpdate == null) {
            return ResponseEntity.ok(testService.getAllTestCases());
        } else {
            return ResponseEntity.ok(testService.getAllTestCasesWithLastUpdateAfter(lastUpdate));
        }
    }
}
