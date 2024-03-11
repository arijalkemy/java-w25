package com.example.QATesters.repository;

import com.example.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {
}
