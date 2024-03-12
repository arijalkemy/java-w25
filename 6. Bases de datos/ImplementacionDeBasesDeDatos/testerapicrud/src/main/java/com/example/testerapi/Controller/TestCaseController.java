package com.example.testerapi.Controller;

import com.example.testerapi.dtos.MessageDto;
import com.example.testerapi.dtos.TestRequestdto;
import com.example.testerapi.dtos.TestResponsedto;
import com.example.testerapi.model.TestCase;
import com.example.testerapi.service.TestCaseService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {
    TestCaseService service;

    public TestCaseController(TestCaseService testCaseService) {
        this.service=testCaseService;
    }
    @PostMapping("/testcases/new")
    public ResponseEntity<TestResponsedto> createTestCase(@RequestBody TestRequestdto testCase) {return new ResponseEntity<>(service.saveTestCase(testCase),HttpStatus.CREATED);}

    @GetMapping("/testcases")
    public ResponseEntity<List<TestResponsedto>> getAllTestCases(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestResponsedto> getTestCaseById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.ok(service.findTestCase(id));
    }


    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return ResponseEntity.ok(service.DeleteTestCase(id));
    }
    @GetMapping("/testcasesbydate")
    public ResponseEntity<?> getTestCasesByDate(@RequestParam LocalDate date){
        return ResponseEntity.ok(service.getTestCasesByDate(date));
    }
    @PutMapping("/testcase/{id}")
    public ResponseEntity<?> updateTestCase(@RequestBody TestRequestdto requestdto,@PathVariable Long id) throws BadRequestException {
        return new ResponseEntity<>(service.updateTestCase(requestdto,id),HttpStatus.OK);
    }

}
