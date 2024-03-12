package com.bootcamp.LasPerlas.repository;
import com.bootcamp.LasPerlas.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQARepository extends JpaRepository <TestCase, Long> {
}
