package bootcamp.qatesters.controller;

import bootcamp.qatesters.dto.request.TestCaseRequest;
import bootcamp.qatesters.model.TestCase;
import bootcamp.qatesters.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService serviceTest;

    public TestCaseController(ITestCaseService testCaseService) {
        this.serviceTest = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody TestCaseRequest request) {
        serviceTest.saveTestCase(request);
        return ResponseEntity.ok("El caso de prueba fue agregado correctamente");
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getTestCases(@RequestParam(value = "last_update", required = false) String lastUpdate) {
        if (lastUpdate != null) return ResponseEntity.ok(serviceTest.findTestCasesAfterLastUpdate(lastUpdate));
        return ResponseEntity.ok(serviceTest.findTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable long id) {
        return ResponseEntity.ok(serviceTest.findTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable long id, @RequestBody TestCaseRequest request) {
        serviceTest.updateTestCase(id, request);
        return ResponseEntity.ok("El caso de prueba fue editado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase (@PathVariable long id) {
        serviceTest.deleteTestCase(id);
        return ResponseEntity.ok("El caso de prueba fue borrado correctamente");
    }

}
