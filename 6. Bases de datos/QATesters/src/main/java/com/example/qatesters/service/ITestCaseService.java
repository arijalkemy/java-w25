package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {


    TestCaseDto save(TestCaseDto testCase);
    TestCaseDto findById(Long id);
    void deleteTestById(Long id);
    List<TestCaseDto> findAllTests();
    TestCaseDto update(TestCaseDto testCase);
    List<TestCaseDto> filterByDate(LocalDate date);

}
