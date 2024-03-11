package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.dto.TestIdDto;
import com.mercadolibre.qatesters.service.ITestCaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
@AllArgsConstructor
public class TesterController {
    private final ITestCaseService testCaseService;
    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDto testCaseDto) {
        return ResponseEntity.ok().body(testCaseService.saveTestCase(testCaseDto));
    }

    @GetMapping()
    public ResponseEntity<?> searchAllTestCases() {
        return ResponseEntity.ok().body(testCaseService.searchAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(testCaseService.searchTestCaseById(new TestIdDto(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return  ResponseEntity.ok().body(testCaseService.updateTestCaseById(new TestIdDto(id)), testCaseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(testCaseService.deleteTestCaseById(new TestIdDto(id)));
    }

    @GetMapping
    public ResponseEntity<?> searchByLastUpdate(@RequestParam LocalDate lastUpdate) {
        return  ResponseEntity.ok().body(testCaseService.searchTestCaseByLastUpdate(lastUpdate));
    }


}
