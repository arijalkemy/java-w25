package com.example.qa_testers.repository;

import com.example.qa_testers.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("SELECT tc FROM TestCase tc WHERE tc.lastUpdate > ?1")
    List<TestCase> findAfterLastUpdate(LocalDate lastUpdate);
}