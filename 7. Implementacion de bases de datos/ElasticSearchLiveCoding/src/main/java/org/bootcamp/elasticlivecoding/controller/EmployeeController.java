package org.bootcamp.elasticlivecoding.controller;

import org.bootcamp.elasticlivecoding.dto.EmployeeDto;
import org.bootcamp.elasticlivecoding.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
    }

    @GetMapping("")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(employeeService.getAll());
    }


}
