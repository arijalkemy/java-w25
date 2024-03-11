package com.implementacionbasedatos.ejercicio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.implementacionbasedatos.ejercicio1.dto.req.TestCaseReqDTO;
import com.implementacionbasedatos.ejercicio1.dto.res.TestCaseResDTO;
import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDTO;
import com.implementacionbasedatos.ejercicio1.service.ITestCaseService;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService iTestCaseService;

    @GetMapping("")
    public ResponseEntity<List<TestCaseResDTO>> getTestCase() {
        List<TestCaseResDTO> TestCaseList = iTestCaseService.getTestCase();
        return new ResponseEntity<>(TestCaseList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/lastupdate")
    public ResponseEntity<List<TestCaseResDTO>> getLastUpdates(
            @RequestParam String last_update) {
        List<TestCaseResDTO> TestCaseList = iTestCaseService.getLastUpdates(last_update);
        return new ResponseEntity<>(TestCaseList, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/new")
    public ResponseEntity<MessageResDTO> postTestCase(@RequestBody TestCaseReqDTO TestCaseDTO) {
        MessageResDTO messageRes = iTestCaseService.postTestCase(TestCaseDTO);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResDTO> deleteTestCase(@PathVariable long id) {
        MessageResDTO messageRes = iTestCaseService.deleteTestCase(id);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(204));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResDTO> putTestCase(@PathVariable long id,
            @RequestBody TestCaseReqDTO TestCaseDTO) {
        TestCaseResDTO TestCaseRes = iTestCaseService.putTestCase(id, TestCaseDTO);
        return new ResponseEntity<>(TestCaseRes, HttpStatusCode.valueOf(200));
    }

}
