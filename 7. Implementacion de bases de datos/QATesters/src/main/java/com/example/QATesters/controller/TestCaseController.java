package com.example.QATesters.controller;

import com.example.QATesters.dto.TestCaseRequestDTO;
import com.example.QATesters.dto.TestCaseResponseDto;
import com.example.QATesters.service.ITestCaseService;
import com.example.QATesters.service.TestCaseService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.save(testCaseRequestDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) String last_update) {
        return new ResponseEntity<>(testCaseService.findAll(last_update), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.update(id, testCaseRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);
    }

}
