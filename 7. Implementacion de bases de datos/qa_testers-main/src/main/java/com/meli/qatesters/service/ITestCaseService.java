package com.meli.qatesters.service;

import com.meli.qatesters.dto.CreateTestCaseDto;
import com.meli.qatesters.dto.ResTestCaseDto;
import com.meli.qatesters.dto.ResponseMessageDto;
import com.meli.qatesters.model.TestCase;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public ResTestCaseDto createTestCase(CreateTestCaseDto test);
    public List<ResTestCaseDto> getAllTestCases();
    public ResTestCaseDto getTestCase(Long id);
    public ResTestCaseDto updateTestCase(Long id, CreateTestCaseDto test);
    public ResponseMessageDto deleteTestCase(Long id);
    public List<ResTestCaseDto> getAllTestCasesAfterDate(LocalDate date);
}
