package com.nq.testcases.service;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseDTO;
import com.nq.testcases.dto.TestCaseResponseIdDTO;

import java.time.LocalDate;
import java.util.List;

public interface TestService {
    TestCaseResponseIdDTO createTestCase(TestCaseRequestDTO newTestCase);

    List<TestCaseResponseIdDTO> getAllTestCases();

    List<TestCaseResponseIdDTO> getAllTestCasesWithLastUpdateAfter(LocalDate date);

    TestCaseResponseIdDTO getTestCaseById(Long id);

    TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO updatedTestCase);

    void deleteTestCase(Long id);
}
