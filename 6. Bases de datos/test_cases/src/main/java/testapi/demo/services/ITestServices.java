package testapi.demo.services;


import testapi.demo.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestServices {

    public List<TestCase> getAllTestCases();
    public List<TestCase> getTestCasesByLastUpdated(LocalDate lastUpdate);
    public TestCase getTestCaseById(Long id);
    public TestCase createTestCase(TestCase testCase);
    public TestCase updateTestCase(Long id, TestCase testCase);
    public void deleteTestCase(Long id);
}
