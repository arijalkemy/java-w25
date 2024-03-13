package com.implementacionbd.ejercicio.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementacionbd.ejercicio.dto.req.EmployeeReqDTO;
import com.implementacionbd.ejercicio.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatusCode.valueOf(201));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeReqDTO employeeReqDTO) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeReqDTO), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatusCode.valueOf(204));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody EmployeeReqDTO employeeReqDTO) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeReqDTO), HttpStatusCode.valueOf(200));
    }
}
