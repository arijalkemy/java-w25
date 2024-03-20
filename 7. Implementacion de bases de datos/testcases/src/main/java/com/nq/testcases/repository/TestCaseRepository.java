package com.nq.testcases.repository;

import com.nq.testcases.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdateAfter(@Param("date") LocalDate date);
}
