package com.bootcamp.testcase.service;

import com.bootcamp.testcase.dto.ResponseMessageDto;
import com.bootcamp.testcase.dto.TestCaseDto;
import com.bootcamp.testcase.exceptions.NotFoundException;
import com.bootcamp.testcase.model.TestCase;
import com.bootcamp.testcase.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestCaseService implements ITestCaseService{


    private final ITestCaseRepository testCaseRepository;
    public TestCaseService(ITestCaseRepository iTestCaseRepository) {
        this.testCaseRepository = iTestCaseRepository;
    }


    @Override
    public ResponseMessageDto saveTest(TestCaseDto testCaseDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        TestCase testCase = objectMapper.convertValue(testCaseDto, TestCase.class);
        testCaseRepository.save(testCase);
        return new ResponseMessageDto("Test creado correctamente");
    }

    @Override
    public List<TestCaseDto> getTests() {
        ModelMapper modelMapper = new ModelMapper();
        return this.testCaseRepository.findAll().stream().map(testCase -> modelMapper.map(testCase, TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto findTest(Long id) {

        ObjectMapper objectMapper = new ObjectMapper();
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Tets no encontrado"));
        return objectMapper.convertValue(testCase, TestCaseDto.class);
    }

    @Override
    public ResponseMessageDto deleteTest(Long id) {
        testCaseRepository.deleteById(id);
        return new ResponseMessageDto("Test eliminado correctamente");
    }

    @Override
    public String editTest(Long id_modificar, TestCaseDto test_modif) {
        return null;
    }

    @Override
    public List<TestCaseDto> allCaseUp(String date) {
        //find all test case with last_update > date
        ModelMapper modelMapper = new ModelMapper();
        return this.testCaseRepository.allCaseUp(date).stream().map(testCase -> modelMapper.map(testCase, TestCaseDto.class)).toList();
        
    }
}
