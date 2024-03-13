package com.nq.testcases.service;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface TestService {
    TestCaseResponseDTO createTestCase(TestCaseRequestDTO newTestCase);

    List<TestCaseResponseDTO> getAllTestCases();

    List<TestCaseResponseDTO> getAllTestCasesWithLastUpdateAfter(LocalDate date);

    TestCaseResponseDTO getTestCaseById(Long id);

    TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO updatedTestCase);

    void deleteTestCase(Long id);
}
