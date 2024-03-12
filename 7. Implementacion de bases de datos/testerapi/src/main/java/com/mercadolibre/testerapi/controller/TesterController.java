package com.mercadolibre.testerapi.controller;

import com.mercadolibre.testerapi.dto.TestCaseDto;
import com.mercadolibre.testerapi.dto.TesterDto;
import com.mercadolibre.testerapi.service.ITesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TesterController {
    ITesterService testerService;
    public TesterController(ITesterService testerService){this.testerService = testerService;}

    @PostMapping("/tester/new")
    public ResponseEntity<?> add(@RequestBody TesterDto testerDto){

        return ResponseEntity
                .ok()
                .body(testerService.save(testerDto));
    }

    @DeleteMapping("/tester/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.GONE).body(testerService.deleteById(id));
    }

    /*
    @GetMapping("/tester/{id}")
    public ResponseEntity<?> findTesterById(@PathVariable Long id) {
        return new ResponseEntity<TesterDto>(testerService.findTesterById(id), HttpStatus.OK);
    }

     */
}
