package bootcamp.qatesters.service.implementation;

import bootcamp.qatesters.dto.request.TestCaseRequest;
import bootcamp.qatesters.exception.TestCaseNotFoundException;
import bootcamp.qatesters.model.TestCase;
import bootcamp.qatesters.repository.TestCaseRepository;
import bootcamp.qatesters.service.ITestCaseService;
import bootcamp.qatesters.util.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImp implements ITestCaseService {

    private final TestCaseRepository testCaseRepository;

    public TestCaseServiceImp(TestCaseRepository TestCaseRepository) {
        this.testCaseRepository = TestCaseRepository;
    }

    @Override
    public List<TestCase> findTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase findTestCaseById(long id) {
        return testCaseRepository.findById(id).orElseThrow(() -> new TestCaseNotFoundException(id));
    }

    @Override
    public void saveTestCase(TestCaseRequest request) {
        TestCase testCase = new TestCase();
        setTestCaseFields(request, testCase);
        testCaseRepository.save(testCase);
    }

    @Override
    public void updateTestCase(Long id, TestCaseRequest request) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new TestCaseNotFoundException(id));
        setTestCaseFields(request, testCase);
        testCaseRepository.save(testCase);
    }

    @Override
    public void deleteTestCase(long id) {
        if (!testCaseRepository.existsById(id))
            throw new TestCaseNotFoundException(id);
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> findTestCasesAfterLastUpdate(String lastUpdate) {
        LocalDate lastUpdateLocalDate = DateFormatter.parseDateString(lastUpdate);
        return testCaseRepository.findTestCaseByLastUpdateAfter(lastUpdateLocalDate);
    }

    private void setTestCaseFields(TestCaseRequest request, TestCase testCase) {
        if (request.getDescription() != null) testCase.setDescription(request.getDescription());
        if (request.getTested() != null) testCase.setTested(request.getTested());
        if (request.getPassed() != null) testCase.setPassed(request.getPassed());
        if (request.getNumberOfTries() != null) testCase.setNumberOfTries(request.getNumberOfTries());
        if (request.getLastUpdate() != null) testCase.setLastUpdate(request.getLastUpdate());
    }

}
