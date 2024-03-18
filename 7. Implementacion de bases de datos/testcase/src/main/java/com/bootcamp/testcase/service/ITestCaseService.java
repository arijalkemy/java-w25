package com.bootcamp.testcase.service;

import com.bootcamp.testcase.dto.ResponseMessageDto;
import com.bootcamp.testcase.dto.TestCaseDto;
import com.bootcamp.testcase.model.TestCase;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ITestCaseService {

    public ResponseMessageDto saveTest(TestCaseDto testCaseDto);
    public List<TestCaseDto> getTests();
    public TestCaseDto findTest(Long id);
    public ResponseMessageDto deleteTest(Long id);
    public String editTest(Long id_modificar, TestCaseDto test_modif);
    public List<TestCaseDto> allCaseUp(String date);

}
