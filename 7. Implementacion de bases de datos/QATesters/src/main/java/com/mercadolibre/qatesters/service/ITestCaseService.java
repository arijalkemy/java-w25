package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.request.TestCaseReqDto;
import com.mercadolibre.qatesters.dto.request.TestIdDto;
import com.mercadolibre.qatesters.dto.response.MessageDto;
import com.mercadolibre.qatesters.dto.response.TestCaseResDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    MessageDto saveTestCase(TestCaseReqDto testCase);

    TestCaseResDto findTestCaseById(TestIdDto testIdDto);

    List<TestCaseResDto> findAllTestCases();

    MessageDto updateTestCaseById(TestIdDto testIdDto, TestCaseReqDto testCaseReqDto);

    List<TestCaseResDto> findTestCaseByLastUpdate(LocalDate lastUpdate);

    MessageDto deleteTestCaseById(TestIdDto idDto);
}
