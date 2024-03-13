package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.dto.TestCaseDTO;
import com.example.ejemplo_jpa.dto.UpdateTestCaseDTO;
import com.example.ejemplo_jpa.service.ITestCaseService;
import com.example.ejemplo_jpa.service.TestCaseService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class Controller {

    //implemento la interface
    private final ITestCaseService testCaseServ;

    public Controller(TestCaseService testCaseService) {
        this.testCaseServ = testCaseService;
    }

    @GetMapping ("/")
    public ResponseEntity<List<TestCaseDTO>> getTestCases() {

        List<TestCaseDTO> testCaseDTOList = testCaseServ.getTestCases();
        return ResponseEntity.ok(testCaseDTOList);

    }

    @GetMapping ("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCases(
            @PathVariable Long id
    ) {

        TestCaseDTO testCaseDTO = testCaseServ.findTestCase(id);
        return ResponseEntity.ok(testCaseDTO);

    }

    @PostMapping ("/new")
      public String createTestCase(
              @RequestBody
              TestCaseDTO testCaseDTO
    ) {
        testCaseServ.saveTestCase(testCaseDTO);
        return "Se creo exitosamente el caso de prueba";
    }

    //acá también puedo poner un objeto y lo relaciona a la id
    // (si se llaman igual ambos parámetros)
    @DeleteMapping("/{id}")
    public String deleteJewel (@PathVariable long id) {
        testCaseServ.deleteTestCase(id);
        return "El caso de prueba fue borrado correctamente";
    }

    @PutMapping ("/{id}")
    public String editTestCase (
            @PathVariable long id,
            @RequestBody UpdateTestCaseDTO updateTestCaseDTO) {
        testCaseServ.updateTestCase(id, updateTestCaseDTO);
        return "Se actualizó correctamente";
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getTestCasesUpdatedAfterDate(
            @RequestParam(value = "last_update", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate last_update
    ) {
        if(last_update != null) {
            List<TestCaseDTO> testCaseDTOList = testCaseServ.findTestCasesUpdatedAfterDate(last_update);
            return ResponseEntity.ok(testCaseDTOList);

        }

        return null;
    }
}
