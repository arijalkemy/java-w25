package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.TestCaseDTO;
import com.example.ejemplo_jpa.dto.UpdateTestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public List<TestCaseDTO> getTestCases();
    public void saveTestCase(TestCaseDTO testCaseDTO);
    public void deleteTestCase(long id);
    public TestCaseDTO findTestCase(long id);

    void updateTestCase(long id, UpdateTestCaseDTO updateTestCaseDTO);

    List<TestCaseDTO> findTestCasesUpdatedAfterDate(LocalDate last_update);
}
