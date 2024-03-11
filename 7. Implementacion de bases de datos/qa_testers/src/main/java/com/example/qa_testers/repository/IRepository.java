package com.example.qa_testers.repository;

import com.example.qa_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRepository extends JpaRepository<TestCase, Long> {
}
