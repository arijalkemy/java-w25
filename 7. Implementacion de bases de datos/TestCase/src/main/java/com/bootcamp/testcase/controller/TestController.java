package com.bootcamp.testcase.controller;

import com.bootcamp.testcase.dto.TestCaseDto;
import com.bootcamp.testcase.service.ITestCaseService;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestController {


    @Autowired
    private ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createTest(@RequestBody TestCaseDto testCaseDto){

        return new ResponseEntity<>(iTestCaseService.saveTest(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseDto>> getAllTest(){

        return new ResponseEntity<>(iTestCaseService.getTests(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestById(@PathVariable Long id){

        return new ResponseEntity<>(iTestCaseService.findTest(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTest(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto){

        return new ResponseEntity<>(iTestCaseService.editTest(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Long id){

        return new ResponseEntity<>(iTestCaseService.deleteTest(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/last_update={date}")
    public  ResponseEntity<List<TestCaseDto>> allCaseUpdate(
        @PathVariable String date
    ){
        return new ResponseEntity<>(iTestCaseService.allCaseUp(date) ,HttpStatus.OK);
    }
}
