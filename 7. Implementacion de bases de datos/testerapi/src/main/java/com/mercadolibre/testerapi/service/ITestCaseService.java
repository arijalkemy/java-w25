package com.mercadolibre.testerapi.service;

import com.mercadolibre.testerapi.dto.MessageDto;
import com.mercadolibre.testerapi.dto.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    List<TestCaseDto> getAll();
    TestCaseDto getById(Long id);
    MessageDto save(TestCaseDto test);
    MessageDto update(Long id, TestCaseDto testCase);
    MessageDto deleteById(Long id);

    List<TestCaseDto> findByDate(String date);

}
