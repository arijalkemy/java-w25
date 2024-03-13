package org.example.elasticdemo1.repository;

import org.example.elasticdemo1.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findAll();
}
