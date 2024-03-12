package com.mercadolibre.elastic.controller;

import com.mercadolibre.elastic.entity.Employee;
import com.mercadolibre.elastic.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository repository;

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(repository.save(employee));
    }
    @GetMapping("/")
    public ResponseEntity<Iterable<Employee>> getAllEmployees(){
        return ResponseEntity.ok(repository.findAll());
    }
}
