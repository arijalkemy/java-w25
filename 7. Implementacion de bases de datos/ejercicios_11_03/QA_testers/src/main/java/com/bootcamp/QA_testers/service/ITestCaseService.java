package com.bootcamp.QA_testers.service;

import com.bootcamp.QA_testers.dto.request.TestCaseReqDTO;
import com.bootcamp.QA_testers.dto.response.TestCaseResDTO;

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
