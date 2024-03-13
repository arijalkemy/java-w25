package com.example.qatesters.controller;

import com.example.qatesters.dto.TestCaseDto;
import com.example.qatesters.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTestById(@PathVariable Long id){

        return  ResponseEntity.ok().body(testCaseService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<?> postTestCase(@RequestBody TestCaseDto testCaseDto){

        return  ResponseEntity.ok().body(testCaseService.save(testCaseDto));
    }


}
