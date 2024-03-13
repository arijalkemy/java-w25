package com.example.elastic.service;

import com.example.elastic.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee save (Employee artic);

    public List<Employee> findAll();

    public Optional<Employee> findById(int id);

    public String deleteEmployee(int id);

    public String editEmployee(Employee employee);
}
