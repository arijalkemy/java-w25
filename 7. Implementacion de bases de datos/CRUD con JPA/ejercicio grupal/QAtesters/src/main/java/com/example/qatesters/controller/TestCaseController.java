package com.example.qatesters.controller;

import com.example.qatesters.dto.GenericResponseDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.dto.TestCaseRequestDTO;
import com.example.qatesters.service.ITestCaseService;
import com.example.qatesters.service.TestCaseServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

  private ITestCaseService testCaseService;

  public TestCaseController(TestCaseServiceImpl testCaseService){ this.testCaseService = testCaseService; }

  @PostMapping("/new")
  public ResponseEntity<TestCaseDTO> createNewTestCase(@RequestBody TestCaseRequestDTO request){
    return ResponseEntity.ok(testCaseService.createTestCase(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
    return ResponseEntity.ok(testCaseService.getTestCaseById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TestCaseDTO> updateTestCaseById(@PathVariable Long id, @RequestBody TestCaseRequestDTO request){
    return ResponseEntity.ok(testCaseService.updateTestCase(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<GenericResponseDTO> deleteTestCaseById(@PathVariable Long id){
    return ResponseEntity.ok(testCaseService.deleteTestCase(id));
  }

  @GetMapping("")
  public ResponseEntity<List<TestCaseDTO>> getTestCasesModifiedAfterDate(@RequestParam(required = false)  String date) {
    return ResponseEntity.ok(testCaseService.getAllTestCases());
  }

}
