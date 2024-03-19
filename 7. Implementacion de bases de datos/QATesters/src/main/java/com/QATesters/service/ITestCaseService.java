package com.QATesters.service;

import com.QATesters.dto.request.RequestTestCaseDto;
import com.QATesters.dto.response.MessageDto;
import com.QATesters.dto.response.TestCaseDto;

import java.util.List;

public interface ITestCaseService {

    List<TestCaseDto> getTestCases(String lastUpdate);
    MessageDto createTestCase(RequestTestCaseDto createTestCaseDto);
    MessageDto deleteTestCase (Long id);
    TestCaseDto getTestCaseById(Long id);
    MessageDto updateTestCase (Long id, RequestTestCaseDto requestTestCaseDto);

}
