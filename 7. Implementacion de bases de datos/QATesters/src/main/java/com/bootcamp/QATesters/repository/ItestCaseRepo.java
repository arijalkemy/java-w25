package com.bootcamp.QATesters.repository;

import com.bootcamp.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItestCaseRepo extends JpaRepository<TestCase,Long> {
    List<TestCase> findByLastupdateAfter(LocalDateTime localDate);

}
