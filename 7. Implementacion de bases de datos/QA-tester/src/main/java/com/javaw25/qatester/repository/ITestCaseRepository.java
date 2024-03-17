package com.javaw25.qatester.repository;

import com.javaw25.qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

}
