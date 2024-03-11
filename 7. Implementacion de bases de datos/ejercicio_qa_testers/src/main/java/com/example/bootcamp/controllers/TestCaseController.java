package com.example.bootcamp.controllers;

import com.example.bootcamp.dto.request.TestCaseDTO;
import com.example.bootcamp.dto.response.TestCaseDTOResponse;
import com.example.bootcamp.dto.response.TestCaseDeleteDTO;
import com.example.bootcamp.model.TestCase;
import com.example.bootcamp.services.ITestCaseService;
import com.example.bootcamp.services.TestCaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseServiceImp testCaseServiceImp;

    @PostMapping("/new") // Funca bien
    public ResponseEntity<?> newTest (@RequestBody TestCaseDTO test) {
        return new ResponseEntity<>(testCaseServiceImp.create(test),HttpStatus.CREATED);
    }

    @GetMapping() // Funca mal
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "") String last_update){
        return ResponseEntity.ok(testCaseServiceImp.findAll(last_update));
    }

    @GetMapping("/{id}") // Funca bien
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseServiceImp.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,
                                        @RequestBody TestCaseDTO testCaseDTO){
        return  ResponseEntity.ok(testCaseServiceImp.update(id, testCaseDTO));
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(new TestCaseDeleteDTO("Se eliminó correctamente", id));
    }

}
