package com.example.qa_testers.service;

import com.example.qa_testers.dto.request.UpsertTestCaseDTO;
import com.example.qa_testers.dto.response.MessageDTO;
import com.example.qa_testers.dto.response.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {
    TestCaseDTO create(UpsertTestCaseDTO testCase);
    List<TestCaseDTO> getAll();
    TestCaseDTO getById(Long id);
    TestCaseDTO update(Long id, UpsertTestCaseDTO updatedTestCase);
    MessageDTO delete(Long id);
    List<TestCaseDTO> getAfterUpdateDate(String date);
}