package com.bootcamp.ejercicio_qatester.repository;

import com.bootcamp.ejercicio_qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long>{
}
