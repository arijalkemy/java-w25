package com.example.bootcamp.repositories;

import com.example.bootcamp.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    // public List<TestCase> findByLast_update(LocalDate last_update);
}
