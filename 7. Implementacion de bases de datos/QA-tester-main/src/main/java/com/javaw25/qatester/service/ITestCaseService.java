package com.javaw25.qatester.service;

import com.javaw25.qatester.dto.MessageDto;
import com.javaw25.qatester.dto.TestCaseDto;
import com.javaw25.qatester.dto.request.CreateTestCaseDto;
import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public List<TestCaseDto> getTestCases(String date);
    public TestCaseDto getTestCaseById(Long id);
    public TestCaseDto createTestCase(CreateTestCaseDto testCaseToCreate);
    public TestCaseDto updateTestCase( TestCaseDto testCaseUpdated);
    public void deleteTestCase(Long id);
}
