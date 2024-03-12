package com.bootcamp.QA_testers.controller;

import com.bootcamp.QA_testers.dto.request.TestCaseReqDTO;
import com.bootcamp.QA_testers.dto.response.TestCaseResDTO;
import com.bootcamp.QA_testers.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
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
    public TestCaseResDTO create(@RequestBody TestCaseReqDTO testCase) {
        return service.saveTestCase(testCase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResDTO> update(@PathVariable Long id, @RequestBody TestCaseReqDTO testCaseReqDTO) {
        return new ResponseEntity<>(service.modifyTestCase(id, testCaseReqDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseResDTO>> getAllTestCases() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResDTO> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findTestCase(id));
    }

    @GetMapping("/last_update")
    public ResponseEntity<List<TestCaseResDTO>> getTestCaseAfterDate(@RequestParam("date")  @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        return ResponseEntity.ok(service.findTestCasesAfterDate(date));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        this.service.deleteTestCase(id);
        return new ResponseEntity<>("Eliminacion exitosa", HttpStatus.OK);
    }
}