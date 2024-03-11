package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDto;
import com.example.QATesters.dto.TestCaseRequestDTO;
import com.example.QATesters.dto.TestCaseResponseDto;

import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDto save(TestCaseRequestDTO testCase);
    MessageDto delete(Long id);
    TestCaseResponseDto findById(Long id);
    List<TestCaseResponseDto> findAll(String last_update);

    TestCaseResponseDto update(Long id, TestCaseRequestDTO testCase);

}
