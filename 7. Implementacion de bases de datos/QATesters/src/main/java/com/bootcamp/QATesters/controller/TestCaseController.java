package com.bootcamp.QATesters.controller;

import com.bootcamp.QATesters.dto.SucessDTO;
import com.bootcamp.QATesters.dto.TestCaseDTO;
import com.bootcamp.QATesters.service.ItestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ItestCaseService testCaseService;

    public TestCaseController(ItestCaseService itestCaseService) {
        this.testCaseService = itestCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<SucessDTO> createTestCase(TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> getTestCases(@RequestParam(required = false) LocalDateTime last_update) {
        if (last_update == null) {
            return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(testCaseService.getTestCasesByDate(last_update),HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id) {

        return new ResponseEntity<>(testCaseService.findTestCase(id), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SucessDTO> updateTestCaseById(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {

        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SucessDTO> deleteTestCaseById(@PathVariable Long id) {

        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }
}




