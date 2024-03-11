package meli.com.co.qatesters.controller;

import meli.com.co.qatesters.dto.request.CreateCaseDto;
import meli.com.co.qatesters.dto.request.UpdateCaseDto;
import meli.com.co.qatesters.entity.TestCase;
import meli.com.co.qatesters.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/testcases")
public class TestCaseController {

    private final TestCaseService caseService;

    public TestCaseController(TestCaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<CreateCaseDto> createCase(@RequestBody CreateCaseDto createCaseDto){
        return ResponseEntity.ok().body(caseService.crear(createCaseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id,
                                            @RequestBody UpdateCaseDto caseDto) {
        return new ResponseEntity(caseService.updateCase(id, caseDto), HttpStatus.OK);
    }


    @GetMapping
    public List<TestCase> getAllTestCases() {
        return caseService.getAllTestCases();

    }

//    @GetMapping("/{id")
//    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id){
//            Optional<TestCase> testCase =
//    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCases(@PathVariable Long id){
        return new ResponseEntity<>(caseService.deleteCase(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{date}")
    public ResponseEntity<TestCase> getByDate(@PathVariable(value = "date")LocalDate date){
        return ResponseEntity.ok().body(caseService.getByLastUpdate(date));
    }
}
