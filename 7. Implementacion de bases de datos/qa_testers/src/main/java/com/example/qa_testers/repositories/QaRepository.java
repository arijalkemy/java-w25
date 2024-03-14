package com.example.qa_testers.repositories;

import com.example.qa_testers.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QaRepository extends JpaRepository <TestCase,Long> {
}
