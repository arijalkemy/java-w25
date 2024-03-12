package com.example.ElasticDemo01.repository;

import com.example.ElasticDemo01.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee,String> {

    List<Employee> findAll();
}
