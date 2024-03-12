package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.TestCaseDto;
import com.bootcamp.LasPerlas.model.TestCase;
import com.bootcamp.LasPerlas.service.IQAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestQAController {

    @Autowired
    IQAService testService;

    @PostMapping ("/api/testcases/new")
    public ResponseEntity<?> saveTest(@RequestBody TestCaseDto casoNuevo) {
        return new ResponseEntity<>(testService.saveTest(casoNuevo), HttpStatus.OK);
    }

    @GetMapping ("/api/testcases")
    public ResponseEntity<?> getCases() {
        return new ResponseEntity<>(testService.getTests(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<?> getSingleCase(@PathVariable long id){
        return new ResponseEntity<>(testService.findTest(id), HttpStatus.OK);
    }

    @DeleteMapping ("/api/testcases/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Long id) {
        return new ResponseEntity<>(testService.deleteTest(id),HttpStatus.OK);
    }

    @PutMapping ("/api/testcases/{id}")
    public ResponseEntity<?> updateTest (@PathVariable Long id, @RequestBody TestCaseDto test) {
        return new ResponseEntity<>(testService.editTest(id, test), HttpStatus.OK);
    }

}
