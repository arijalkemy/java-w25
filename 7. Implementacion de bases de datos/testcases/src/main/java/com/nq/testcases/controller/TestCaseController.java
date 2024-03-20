package com.nq.testcases.controller;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseDTO;
import com.nq.testcases.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    //Devolver todos los casos de prueba o los que hayan sido actualizados después de una determinada fecha.
    @GetMapping
    public ResponseEntity<?> getAllTestCases(@RequestParam(name = "last_update", required = false) LocalDate lastUpdate) {
        return lastUpdate != null ?
                ResponseEntity.ok(testService.getAllTestCasesWithLastUpdateAfter(lastUpdate)) :
                ResponseEntity.ok(testService.getAllTestCases());
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
    public ResponseEntity<TestCaseResponseDTO> deleteTestCaseById(@PathVariable Long id) {
        //return ResponseEntity.ok(testService.deleteTestCase(id));
        return null;
    }
}
