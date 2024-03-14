package testapi.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import testapi.demo.model.TestCase;
import testapi.demo.repository.TestCaseRepositosy;
import testapi.demo.services.ITestServices;
import testapi.demo.services.TestServices;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestApiController {

    private ITestServices testServices;

    public TestApiController(ITestServices testServices) {
        this.testServices = testServices;
    }

    @PostMapping("/new")
    public void createTestCase(@RequestBody TestCase testCase) {
        testServices.createTestCase(testCase);
    }

    @GetMapping
    public List<TestCase> getTestCases(@RequestParam("last_updated") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        if (lastUpdate != null) {
            return testServices.getTestCasesByLastUpdated(lastUpdate);
        }
        return testServices.getAllTestCases();
    }
    
    @GetMapping("/{id}")
    public TestCase getTestCase(@PathVariable Long id) {
        return testServices.getTestCaseById(id);
    }

    @PutMapping("/{id}")
    public void UpdateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        testServices.updateTestCase(id, testCase);
    }


    @DeleteMapping("/{id}")
    public String deleteTestCase(@PathVariable Long id) {
        testServices.deleteTestCase(id);
        return "TestCase deleted successfully";
    }



}
