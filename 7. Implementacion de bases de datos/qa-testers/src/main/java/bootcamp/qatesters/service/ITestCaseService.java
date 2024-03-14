package bootcamp.qatesters.service;

import bootcamp.qatesters.dto.request.TestCaseRequest;
import bootcamp.qatesters.model.TestCase;

import java.util.List;

public interface ITestCaseService {

    List<TestCase> findTestCases();

    TestCase findTestCaseById(long id);
    void saveTestCase(TestCaseRequest testCase);
    void updateTestCase(Long id, TestCaseRequest testCase);
    void deleteTestCase(long id);
    List<TestCase> findTestCasesAfterLastUpdate(String lastUpdate);

}
