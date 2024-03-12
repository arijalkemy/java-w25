package com.example.testerapi.service;

import com.example.testerapi.dtos.TestRequestdto;
import com.example.testerapi.dtos.TestResponsedto;
import com.example.testerapi.model.TestCase;
import org.apache.coyote.BadRequestException;

import java.time.LocalDate;
import java.util.List;

public interface ITestCase {

    TestCase DeleteTestCase(Long id);
    TestRequestdto updateTestCase(TestRequestdto requestdto, Long id) throws BadRequestException;
    List<TestCase> getTestCasesByDate(LocalDate date);

}
