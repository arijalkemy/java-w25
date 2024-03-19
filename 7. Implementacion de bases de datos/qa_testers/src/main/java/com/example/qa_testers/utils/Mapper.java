package com.example.qa_testers.utils;

import com.example.qa_testers.dto.request.TestCaseReqDTO;
import com.example.qa_testers.dto.response.TestCaseResDTO;
import com.example.qa_testers.model.TestCase;

public class Mapper {
    public static TestCaseResDTO entityToDTO(TestCase testCase) {
        return new TestCaseResDTO(
                testCase.getId_case(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumber_of_tries(),
                testCase.getLast_update()
        );
    }

    public static TestCase dtoToEntity(TestCaseReqDTO testCaseReqDTO) {
        return new TestCase(
                testCaseReqDTO.description(),
                testCaseReqDTO.tested(),
                testCaseReqDTO.passed(),
                testCaseReqDTO.number_of_tries(),
                testCaseReqDTO.last_update());
    }
}
