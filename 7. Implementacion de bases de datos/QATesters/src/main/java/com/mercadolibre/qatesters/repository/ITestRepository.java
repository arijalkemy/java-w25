package com.mercadolibre.qatesters.repository;

import com.mercadolibre.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdateAfter(LocalDate localDate);
}
