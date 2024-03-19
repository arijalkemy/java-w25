package com.nq.testcases.utils;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseDTO;
import com.nq.testcases.dto.TestCaseResponseIdDTO;
import com.nq.testcases.entity.TestCase;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public abstract class CustomMapper {
    public static TestCase testCaseRequestToTestCase(TestCaseRequestDTO t) {
        return new TestCase(
                t.description(),
                t.tested(),
                t.passed(),
                t.numberOfTries(),
                LocalDate.now()
        );
    }

    public static TestCaseResponseDTO testCaseToTestCaseResponse(TestCase t) {
        return new TestCaseResponseDTO(
                t.getDescription(),
                t.getTested(),
                t.getPassed(),
                t.getNumberOfTries()
        );
    }

    public static TestCaseResponseIdDTO testCaseToTestCaseResponseId(TestCase t) {
        return new TestCaseResponseIdDTO(
                t.getIdCase(),
                t.getDescription(),
                t.getTested(),
                t.getPassed(),
                t.getNumberOfTries(),
                t.getLastUpdate()
        );
    }
}
