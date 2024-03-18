package com.bootcamp.testcase.repository;

import com.bootcamp.testcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query(value = "SELECT * FROM test_case WHERE last_update > ?", nativeQuery = true)
    public List<TestCase> allCaseUp(String date);

    public List<TestCase> findByLastUpdateAfter(LocalDate date);
}
