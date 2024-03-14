package testapi.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import testapi.demo.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface TestCaseRepositosy extends JpaRepository<TestCase, Long>{

    @Query("SELECT t FROM TestCase t WHERE t.Last_updated = ?1")
    List<TestCase> findByLastUpdated(LocalDate lastUpdated);
}
