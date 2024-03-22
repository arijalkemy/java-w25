package com.integrationelastic.exercise.repository;

import com.integrationelastic.exercise.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    // Metodo para retornar todos
    List<Employee> findAll();
}
