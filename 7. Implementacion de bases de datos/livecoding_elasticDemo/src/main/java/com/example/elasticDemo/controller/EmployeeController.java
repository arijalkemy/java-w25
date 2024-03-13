package com.example.elasticDemo.controller;

import com.example.elasticDemo.dto.EmployeeDTO;
import com.example.elasticDemo.services.EmployeeServices;
import com.example.elasticDemo.services.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private IEmployeeService employeeServices;

    public EmployeeController(EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeServices.save(employeeDTO));
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(employeeServices.findAll());
    }
}
