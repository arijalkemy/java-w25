package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.MessageDto;
import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.dto.TestIdDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    MessageDto saveTestCase(TestCaseDto testCase);

    TestCaseDto searchTestCaseById(TestIdDto id, TestCaseDto testCaseDto);

    List<TestCaseDto> searchAllTestCases();

    MessageDto updateTestCaseById();

    List<TestCaseDto> searchTestCaseByLastUpdate(LocalDate lastUpdate);

    MessageDto deleteTestCaseById(TestIdDto idDto);
}
