package com.bootcamp.testcase.service;

import com.bootcamp.testcase.dto.ResponseMessageDto;
import com.bootcamp.testcase.dto.TestCaseDto;
import com.bootcamp.testcase.exceptions.NotFoundException;
import com.bootcamp.testcase.model.TestCase;
import com.bootcamp.testcase.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class TestCaseService implements ITestCaseService{


    private final ITestCaseRepository testCaseRepository;
    public TestCaseService(ITestCaseRepository iTestCaseRepository) {
        this.testCaseRepository = iTestCaseRepository;
    }


    @Override
    public ResponseMessageDto saveTest(TestCaseDto testCaseDto) {
        ModelMapper mapper = new ModelMapper();
        TestCase testCase = mapper.map(testCaseDto, TestCase.class);
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

        ModelMapper modelMapper = new ModelMapper();
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Tets no encontrado"));
        return modelMapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public ResponseMessageDto deleteTest(Long id) {
        testCaseRepository.deleteById(id);
        return new ResponseMessageDto("Test eliminado correctamente");
    }

    @Override
    public String editTest(Long id_modificar, TestCaseDto test_modif) {

        TestCase testCase = testCaseRepository.findById(id_modificar).orElseThrow(() -> new NotFoundException("Tets no encontrado"));
        return null;
    }

    @Override
    public List<TestCaseDto> allCaseUp(String date) {
        //find all test case with last_update > date
        ModelMapper modelMapper = new ModelMapper();
        LocalDate localDate = LocalDate.parse(date);
        return this.testCaseRepository.findByLastUpdateAfter(localDate).stream().map(testCase -> modelMapper.map(testCase, TestCaseDto.class)).toList();
        
    }
}
