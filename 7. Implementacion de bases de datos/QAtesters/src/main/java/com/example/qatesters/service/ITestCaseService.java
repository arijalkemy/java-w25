package com.example.qatesters.service;

import com.example.qatesters.dto.GenericResponseDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.dto.TestCaseRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITestCaseService {
  TestCaseDTO createTestCase(TestCaseRequestDTO testCaseDTO);
  List<TestCaseDTO> getAllTestCases();
  TestCaseDTO getTestCaseById(Long id);
  TestCaseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseDTO);
  GenericResponseDTO deleteTestCase(Long id);
}
