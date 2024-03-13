package org.example.elasticdemo1.controller;

import org.example.elasticdemo1.dto.EmployeeDto;
import org.example.elasticdemo1.service.EmployeeServiceImpl;
import org.example.elasticdemo1.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    IEmployeeService service;

    EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?> saveEmployee(
            @RequestBody
            EmployeeDto employeeDto
    ) {
        return ResponseEntity.ok(service.saveEmployee(employeeDto));
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
