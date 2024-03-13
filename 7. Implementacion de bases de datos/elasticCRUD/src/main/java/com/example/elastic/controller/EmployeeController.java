package com.example.elastic.controller;

import com.example.elastic.model.Employee;
import com.example.elastic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/new")
    public Employee save (@RequestBody Employee emp) {
        return employeeService.save(emp);

    }

    @GetMapping("/employee")
    public List<Employee> findAll () {

        return employeeService.findAll();
    }

    @GetMapping ("/employee/{id}")
    //va optional porque puede que devuelva como puede que no
    public Optional<Employee> findById(@PathVariable int id) {

        return employeeService.findById(id);
    }

    @DeleteMapping ("employee/delete/{id}")
    public String deleteEmployee (@PathVariable int id) {

        return employeeService.deleteEmployee(id);
    }

    @PutMapping ("employee/edit")
    public String editEmployee (@RequestBody Employee artic) {

        return employeeService.editEmployee(artic);
    }

}
