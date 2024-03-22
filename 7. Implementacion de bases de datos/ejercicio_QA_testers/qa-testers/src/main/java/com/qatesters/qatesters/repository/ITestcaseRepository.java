package com.qatesters.qatesters.repository;

import com.qatesters.qatesters.model.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestcaseRepository extends JpaRepository<Testcase, Long> {
}
