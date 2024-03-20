package com.bootcamp.service;

import com.bootcamp.dto.request.ReqTestCaseDto;
import com.bootcamp.dto.response.ResTestCaseDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResTestCaseDto createTestCase(ReqTestCaseDto reqTestCaseDto);

    List<ResTestCaseDto> findAll();

    ResTestCaseDto findById(Long id);

    ResTestCaseDto updateTestCase(Long id, ReqTestCaseDto testCaseDto);

    ResTestCaseDto deleteTestCase(Long id);

    List<ResTestCaseDto> findAllSinceDate(LocalDate date);
}
