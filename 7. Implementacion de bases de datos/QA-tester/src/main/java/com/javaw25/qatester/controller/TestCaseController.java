package com.javaw25.qatester.controller;

import com.javaw25.qatester.dto.TestCaseDto;
import com.javaw25.qatester.dto.request.CreateTestCaseDto;
import com.javaw25.qatester.service.ITestCaseService;
import com.javaw25.qatester.service.TestCaseService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService){
        this.testCaseService = testCaseService;
    }

    @PostMapping("/api/testcases/new")
    public ResponseEntity<?> createNewTestCase(@RequestBody CreateTestCaseDto createTestCaseDto){
        return new ResponseEntity<>(testCaseService.createTestCase(createTestCaseDto), HttpStatus.OK);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) String date){
        return new ResponseEntity<>(testCaseService.getTestCases(date), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<?> getTestCaseId(@PathVariable long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<?> updateCaseId(@PathVariable long id,
                                             @RequestBody TestCaseDto testCaseDto){
        testCaseDto.setId_case(id);
        return new ResponseEntity<>(testCaseService.updateTestCase(testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable long id){
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("El elemento con id " + id + " ha sido eliminado", HttpStatus.OK);
    }


}
