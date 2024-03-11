package com.meli.qatesters.repository;

import com.meli.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate last_update);
}
