package com.example.qa_testers.controller;

import com.example.qa_testers.dto.request.TestCaseReqDTO;
import com.example.qa_testers.dto.response.TestCaseResDTO;
import com.example.qa_testers.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/new")
    public TestCaseResDTO create(@RequestBody TestCaseReqDTO testCase) {
        return service.saveTestCase(testCase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResDTO> update(@PathVariable Long id, @RequestBody TestCaseReqDTO testCaseReqDTO) {
        return new ResponseEntity<>(service.modifyTestCase(id, testCaseReqDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseResDTO>> getAllTestCases(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResDTO> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(service.findTestCase(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseResDTO>> getTestCaseAfterDate(@RequestParam("last_update")LocalDate date){
        return ResponseEntity.ok(service.findTestCasesAfterDate(date));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id){
        this.service.deleteTestCase(id);
        return new ResponseEntity<>("Eliminacion exitosa",HttpStatus.OK);
    }
}
