package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.dto.request.TestCaseReqDto;
import com.mercadolibre.qatesters.dto.request.TestIdDto;
import com.mercadolibre.qatesters.dto.response.MessageDto;
import com.mercadolibre.qatesters.dto.response.TestCaseResDto;
import com.mercadolibre.qatesters.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> createTestCase(@RequestBody TestCaseReqDto testCaseReqDto) {
        return ResponseEntity.ok().body(testCaseService.saveTestCase(testCaseReqDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseResDto>> getAllTestCases() {
        return ResponseEntity.ok().body(testCaseService.findAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResDto> getTestById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(testCaseService.findTestCaseById(new TestIdDto(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> updateTestById(@PathVariable Long id, @RequestBody TestCaseReqDto testCaseReqDto) {
        return ResponseEntity.ok().body(testCaseService.updateTestCaseById(new TestIdDto(id), testCaseReqDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteTestById(@PathVariable Long id) {
        return ResponseEntity.ok().body(testCaseService.deleteTestCaseById(new TestIdDto(id)));
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseResDto>> getTestByLastUpdate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastUpdate) {
        return ResponseEntity.ok().body(testCaseService.findTestCaseByLastUpdate(lastUpdate));
    }
}
