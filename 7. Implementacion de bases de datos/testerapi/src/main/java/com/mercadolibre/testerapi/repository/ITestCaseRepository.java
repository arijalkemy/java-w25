package com.mercadolibre.testerapi.repository;

import com.mercadolibre.testerapi.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {
}
