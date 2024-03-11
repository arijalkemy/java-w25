package com.example.qa_testers.controller;

import com.example.qa_testers.dto.request.UpsertTestCaseDTO;
import com.example.qa_testers.dto.response.MessageDTO;
import com.example.qa_testers.dto.response.TestCaseDTO;
import com.example.qa_testers.service.ITestCaseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> createTestCase(
        @Valid @RequestBody UpsertTestCaseDTO createTestCaseDTO
    ) {
        return new ResponseEntity<TestCaseDTO>(testCaseService.create(createTestCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
        return new ResponseEntity<List<TestCaseDTO>>(testCaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(
        @PathVariable Long id
    ) {
        return new ResponseEntity<TestCaseDTO>(testCaseService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(
        @PathVariable Long id,
        @Valid @RequestBody UpsertTestCaseDTO updateTestCaseDTO
    ) {
        return new ResponseEntity<TestCaseDTO>(testCaseService.update(id, updateTestCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteTestCase(
        @PathVariable Long id
    ) {
        return new ResponseEntity<MessageDTO>(testCaseService.delete(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> getTestCasesByLastUpdate(
        @RequestParam String last_update
    ) {
        return new ResponseEntity<List<TestCaseDTO>>(testCaseService.getAfterUpdateDate(last_update), HttpStatus.OK);
    }
}