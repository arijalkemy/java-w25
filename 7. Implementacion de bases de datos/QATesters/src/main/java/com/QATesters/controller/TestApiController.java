package com.QATesters.controller;

import com.QATesters.dto.request.RequestTestCaseDto;
import com.QATesters.service.ITestCaseService;
import com.QATesters.service.TestCaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestApiController {

    private final ITestCaseService testCaseService;

    public TestApiController (TestCaseServiceImpl testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase (@RequestBody RequestTestCaseDto createTestCaseDto){
        return new ResponseEntity<>(testCaseService.createTestCase(createTestCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTestCases (@RequestParam(required = false, value = "last_update") String last_update) {
        return new ResponseEntity<>(testCaseService.getTestCases(last_update), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById (@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCaseById (@PathVariable Long id, @RequestBody RequestTestCaseDto requestTestCaseDto) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, requestTestCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCaseById (@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

}
