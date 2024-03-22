package com.integrationelastic.exercise.controller;

import com.integrationelastic.exercise.dto.EmployeeDto;
import com.integrationelastic.exercise.service.EmployeeService;
import com.integrationelastic.exercise.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    // Create employee
    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto),HttpStatus.OK);
    }

    // Get all employees
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
}
