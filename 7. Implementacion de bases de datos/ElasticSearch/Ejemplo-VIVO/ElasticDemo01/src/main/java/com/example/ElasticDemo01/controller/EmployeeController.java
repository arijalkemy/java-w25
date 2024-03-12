package com.example.ElasticDemo01.controller;

import com.example.ElasticDemo01.dto.EmployeeDto;
import com.example.ElasticDemo01.service.EmployeeServiceImpl;
import com.example.ElasticDemo01.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(service.saveEmployee(employeeDto),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
}
