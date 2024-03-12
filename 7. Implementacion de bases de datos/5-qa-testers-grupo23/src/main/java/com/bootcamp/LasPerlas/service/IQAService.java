package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.ResponseDto;
import com.bootcamp.LasPerlas.dto.TestCaseDto;
import com.bootcamp.LasPerlas.model.TestCase;

import java.util.List;

public interface IQAService {

    public ResponseDto saveTest(TestCaseDto testCase);
    public List<TestCaseDto> getTests();
    public TestCaseDto findTest(Long id);
    public ResponseDto deleteTest(Long id);
    public ResponseDto editTest(Long id_modificar, TestCaseDto test_modif);

}
