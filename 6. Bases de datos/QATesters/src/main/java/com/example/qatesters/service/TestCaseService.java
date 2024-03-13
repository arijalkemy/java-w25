package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseDto;
import com.example.qatesters.entity.TestCase;
import com.example.qatesters.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService{

    private final TestCaseRepository testCaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDto save(TestCaseDto testCase) {
        ModelMapper modelMapper = new ModelMapper();

        TestCase testCaseInsert = modelMapper.map(testCase,TestCase.class);
        TestCase inserted= testCaseRepository.save(testCaseInsert);

        TestCaseDto testCaseDtoReturn = modelMapper.map(inserted,TestCaseDto.class);

        return testCaseDtoReturn;
    }

    @Override
    public TestCaseDto findById(Long id) {
        Optional<TestCase> exists = testCaseRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();

        TestCaseDto testCaseFound;

        if (exists.isPresent()){
                testCaseFound = modelMapper.map(exists.get(),TestCaseDto.class);
        }else {

            throw new RuntimeException("Test not found");
        }

        return testCaseFound;

    }

    @Override
    public void deleteTestById(Long id) {



        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> findAllTests() {
        ModelMapper modelMapper = new ModelMapper();
        return testCaseRepository.findAll().stream().map( testCase -> modelMapper.map(testCase,TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto update(TestCaseDto testCase) {
        return null;
    }

    @Override
    public List<TestCaseDto> filterByDate(LocalDate date) {
        return null;
    }
}
