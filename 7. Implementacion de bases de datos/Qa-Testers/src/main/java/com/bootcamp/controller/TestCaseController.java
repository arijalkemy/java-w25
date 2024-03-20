package com.bootcamp.controller;

import com.bootcamp.dto.request.ReqTestCaseDto;
import com.bootcamp.dto.response.ResTestCaseDto;
import com.bootcamp.service.ITestCaseService;
import com.bootcamp.service.impl.TestCaseServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService testCaseService;

    public TestCaseController(TestCaseServiceImpl testCaseService) {
        this.testCaseService = testCaseService;
    }

    /**
     * Crear un nuevo caso de prueba.
     * @param reqTestCaseDto
     * @return
     */
    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody ReqTestCaseDto reqTestCaseDto){
        return new ResponseEntity<>(this.testCaseService.createTestCase(reqTestCaseDto), HttpStatus.OK);
    }

    /**
     * Devolver todos los casos de prueba.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ResTestCaseDto>> getAllTestCases(
            @RequestParam(name = "last_update", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        System.out.println(date);
        if(date == null){
            return new ResponseEntity<>(this.testCaseService.findAll(), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(this.testCaseService.findAllSinceDate(date), HttpStatus.OK);

        }
    }

    /**
     * Devolver un caso de prueba por id.
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResTestCaseDto> getTestCaseById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.testCaseService.findById(id), HttpStatus.OK);
    }

    /**
     * Actualizar un caso de prueba por id.
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResTestCaseDto> updateTestCase(@PathVariable("id") Long id, @RequestBody ReqTestCaseDto testCaseDto){
        return new ResponseEntity<>(this.testCaseService.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }
    /**
     * Eliminar un tutorial por id.
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResTestCaseDto> deleteTestCase(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.testCaseService.deleteTestCase(id), HttpStatus.OK);
    }



}
