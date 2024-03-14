package bootcamp.qatesters.repository;

import bootcamp.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findTestCaseByLastUpdateAfter(LocalDate date);

}
