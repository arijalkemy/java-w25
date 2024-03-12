package com.bootcamp.QATesters.service;

import com.bootcamp.QATesters.dto.SucessDTO;
import com.bootcamp.QATesters.dto.TestCaseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ItestCaseService {
    public List<TestCaseDTO> getTestCases();
    public List<TestCaseDTO> getTestCasesByDate(LocalDateTime date);
    public SucessDTO saveTestCase(TestCaseDTO testCaseDTO);
    public SucessDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);
    public TestCaseDTO findTestCase(long id);
    public SucessDTO deleteTestCase(Long id);

}