package com.qatesters.qatesters.service;


import com.qatesters.qatesters.dto.request.TestcaseDTO;
import com.qatesters.qatesters.dto.response.GenericResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestcaseService {
    public TestcaseDTO createTestcase(TestcaseDTO testcaseDTO);

    public List<TestcaseDTO> getAll(String lastUpdated);

    public TestcaseDTO getTestcaseById(Long id);

    public TestcaseDTO updateTestcase(Long id, TestcaseDTO testcaseDTO);

    public GenericResponseDTO deleteTestcase(Long id);

    public List<TestcaseDTO> getTestcaseByDate(LocalDate lastUpdated);
}
