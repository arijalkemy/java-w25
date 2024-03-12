package com.bootcamp.QA_testers.util;

import com.bootcamp.QA_testers.dto.request.TestCaseReqDTO;
import com.bootcamp.QA_testers.dto.response.TestCaseResDTO;
import com.bootcamp.QA_testers.model.TestCase;

public class Mapper {
    public static TestCaseResDTO entityToDTO(TestCase testCase) {
        return new TestCaseResDTO(
                testCase.getId(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
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
