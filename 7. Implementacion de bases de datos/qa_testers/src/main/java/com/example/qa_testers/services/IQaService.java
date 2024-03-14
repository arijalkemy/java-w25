package com.example.qa_testers.services;

import com.example.qa_testers.dtos.RequestTestCaseDto;
import com.example.qa_testers.dtos.ResponseTestCaseDto;
import com.example.qa_testers.entities.TestCase;
import org.apache.coyote.Response;

import java.util.List;

public interface IQaService {

    ResponseTestCaseDto saveTestCase(RequestTestCaseDto testCase);
    List<TestCase> getAll();
    void deleteById(Long id);
    ResponseTestCaseDto getById(Long id);
    ResponseTestCaseDto updateById(Long id, RequestTestCaseDto requestTestCaseDto);
}
