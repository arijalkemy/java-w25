package com.example.qa_testers.controllers;

import com.example.qa_testers.dtos.RequestTestCaseDto;
import com.example.qa_testers.dtos.ResponseTestCaseDto;
import com.example.qa_testers.services.IQaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class QaController {

    private IQaService service;

    public QaController (IQaService service){
        this.service = service;
    }

    //OK
    @GetMapping("")
    public ResponseEntity<?> getAll(){return new ResponseEntity<>(service.getAll(), HttpStatus.OK);}
    //@RequestParam(required = false)Date last_update

    //OK
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTestCaseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    //OK
    @PostMapping("/new")
    public ResponseEntity<ResponseTestCaseDto> createTestCase(@RequestBody RequestTestCaseDto testCase){
        return new ResponseEntity<>(service.saveTestCase(testCase),HttpStatus.OK);
    }

    //OK
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTestCaseDto> updateById(@PathVariable Long id, @RequestBody RequestTestCaseDto testCase){
        return new ResponseEntity<>(service.updateById(id, testCase), HttpStatus.OK);
    }
}
