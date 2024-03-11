package com.bootcamp.ejercicio_qatester.service;

import com.bootcamp.ejercicio_qatester.dto.request.TestCaseDTO;
import com.bootcamp.ejercicio_qatester.dto.response.GenericResponseDTO;

import java.util.List;
import java.time.LocalDate;

public interface ITestCaseService {

    public TestCaseDTO createTestCase(TestCaseDTO testCase);

    public List<TestCaseDTO> getAll(String last_update);

    public TestCaseDTO getTestCaseById(Long id);

    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCase);

    public GenericResponseDTO deleteTestCase(Long id);

    public List<TestCaseDTO> getTestCaseByDates(LocalDate last_update);
}
