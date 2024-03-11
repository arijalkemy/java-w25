package com.example.bootcamp.services;

import com.example.bootcamp.dto.request.TestCaseDTO;
import com.example.bootcamp.dto.response.TestCaseDTOResponse;
import com.example.bootcamp.model.TestCase;

import java.util.List;

public interface ITestCaseService {

    public TestCaseDTOResponse findById(Long id);
    public void delete(Long id);
    public TestCaseDTOResponse create(TestCaseDTO testCaseDTO);
    public TestCase update(Long id, TestCaseDTO testCaseDTO);
    public List<TestCaseDTOResponse> findAll(String last_update);

}
