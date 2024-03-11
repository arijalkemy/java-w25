package com.meli.qatesters.controller;

import com.meli.qatesters.dto.CreateTestCaseDto;
import com.meli.qatesters.dto.ResTestCaseDto;
import com.meli.qatesters.dto.ResponseMessageDto;
import com.meli.qatesters.service.ITestCaseService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private ITestCaseService service;

    public TestCaseController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<ResTestCaseDto> newTestCase(@RequestBody CreateTestCaseDto createTestCaseDto) {
        return ResponseEntity.ok(service.createTestCase(createTestCaseDto));
    }

    @GetMapping("")
    public ResponseEntity<List<ResTestCaseDto>> getAllTestCases() {
        return ResponseEntity.ok(service.getAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResTestCaseDto> getTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResTestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody CreateTestCaseDto testCase) {
        return ResponseEntity.ok(service.updateTestCase(id, testCase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteTestCase(id),HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<?> getAllTestCasesUpdatedAfter(@RequestParam LocalDate last_update) {
        return ResponseEntity.ok(service.getAllTestCasesAfterDate(last_update));
    }
}
