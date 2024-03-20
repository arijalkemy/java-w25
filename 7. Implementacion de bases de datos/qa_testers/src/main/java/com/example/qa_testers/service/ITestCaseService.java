package com.example.qa_testers.service;

import com.example.qa_testers.dto.request.TestCaseReqDTO;
import com.example.qa_testers.dto.response.TestCaseResDTO;
import com.example.qa_testers.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResDTO findTestCase (Long id);
    void deleteTestCase(Long id);
    TestCaseResDTO saveTestCase(TestCaseReqDTO testCase);
    List<TestCaseResDTO> findAll();
    TestCaseResDTO modifyTestCase(Long id, TestCaseReqDTO testCase);

    List<TestCaseResDTO> findTestCasesAfterDate(LocalDate date);
}
