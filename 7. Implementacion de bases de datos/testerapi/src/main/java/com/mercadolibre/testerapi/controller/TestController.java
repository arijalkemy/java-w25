package com.mercadolibre.testerapi.controller;

import com.mercadolibre.testerapi.dto.TestCaseDto;
import com.mercadolibre.testerapi.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    ITestCaseService testService;

    public  TestController(ITestCaseService test) {
        this.testService = test;
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<?> add(@RequestBody TestCaseDto testDto){

        return ResponseEntity
                .ok()
                .body(testService.save(testDto));
    }

    @GetMapping("/testcases")
    public ResponseEntity<?> getAll(){

        return ResponseEntity
                .ok()
                .body(testService.getAll());
    }


    @GetMapping("/testcases/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        return ResponseEntity.ok().body(testService.getById(id));
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody TestCaseDto test){

        return ResponseEntity.ok().body(testService.update(id, test));
    }

    @DeleteMapping("/testcase/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.GONE).body(testService.deleteById(id));
    }
}
