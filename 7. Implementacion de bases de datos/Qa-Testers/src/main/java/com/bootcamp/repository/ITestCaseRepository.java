package com.bootcamp.repository;

import com.bootcamp.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("FROM TestCase t WHERE t.lastUpdate > :date")
    List<TestCase> findAllSinceDate(@Param("date") LocalDate date);
}
