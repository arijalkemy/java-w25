package testapi.demo.services;

import org.springframework.stereotype.Service;
import testapi.demo.model.TestCase;
import testapi.demo.repository.TestCaseRepositosy;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestServices implements ITestServices{
    private TestCaseRepositosy testCaseRepositosy;

    public TestServices(TestCaseRepositosy testCaseRepositosy) {
        this.testCaseRepositosy = testCaseRepositosy;
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepositosy.findAll();
    }

    public List<TestCase> getTestCasesByLastUpdated(LocalDate lastUpdate) {
        return testCaseRepositosy.findByLastUpdated(lastUpdate);
    }

    public TestCase getTestCaseById(Long id) {
        return testCaseRepositosy.findById(id).orElseThrow(() -> new RuntimeException("TestCase not found"));
    }

    public TestCase createTestCase(TestCase testCase) {
        return testCaseRepositosy.save(testCase);
    }

    public TestCase updateTestCase(Long id, TestCase testCase) {
        TestCase testCaseToUpdate = testCaseRepositosy.findById(id).orElseThrow(() -> new RuntimeException("TestCase not found"));
        testCaseToUpdate.setDescription(testCase.getDescription());
        testCaseToUpdate.setTested(testCase.getTested());
        testCaseToUpdate.setPassed(testCase.getPassed());
        testCaseToUpdate.setNumber_of_tries(testCase.getNumber_of_tries());
        testCaseToUpdate.setLast_updated(testCase.getLast_updated());
        return testCaseRepositosy.save(testCaseToUpdate);
    }

    public void deleteTestCase(Long id) {
        testCaseRepositosy.deleteById(id);
    }
}
