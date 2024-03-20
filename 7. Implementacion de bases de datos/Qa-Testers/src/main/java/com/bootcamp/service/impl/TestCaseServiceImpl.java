package com.bootcamp.service.impl;

import com.bootcamp.dto.request.ReqTestCaseDto;
import com.bootcamp.dto.response.ResTestCaseDto;
import com.bootcamp.model.TestCase;
import com.bootcamp.repository.ITestCaseRepository;
import com.bootcamp.service.ITestCaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private ITestCaseRepository testCaseRepository;
    private ModelMapper mapper = new ModelMapper();
    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public ResTestCaseDto createTestCase(ReqTestCaseDto reqTestCaseDto) {
        TestCase testCase = this.testCaseRepository.save(mapper.map( reqTestCaseDto, TestCase.class));

        return mapper.map(testCase, ResTestCaseDto.class);
    }

    @Override
    public List<ResTestCaseDto> findAll() {
        return this.testCaseRepository.findAll().stream()
                .map(testCase -> mapper.map(testCase, ResTestCaseDto.class)).toList();
    }

    @Override
    public ResTestCaseDto findById(Long id) {
        return mapper.map(findTestCaseById(id), ResTestCaseDto.class);
    }

    private TestCase findTestCaseById(Long id){
        return this.testCaseRepository.findById(id).orElseThrow(()
                -> new RuntimeException("No se encuentra el test case con id " + id));
    }

    @Override
    public ResTestCaseDto updateTestCase(Long id, ReqTestCaseDto testCaseDto) {

        TestCase existingTestCase = findTestCaseById(id);
        TestCase updatedTestCase = mapper.map(testCaseDto, TestCase.class);
        updatedTestCase.setIdCase(existingTestCase.getIdCase());

        return mapper.map(this.testCaseRepository.save(updatedTestCase), ResTestCaseDto.class);
    }

    @Override
    public ResTestCaseDto deleteTestCase(Long id) {
        TestCase testCase = findTestCaseById(id);
        this.testCaseRepository.delete(testCase);
        return mapper.map(testCase, ResTestCaseDto.class);
    }

    @Override
    public List<ResTestCaseDto> findAllSinceDate(LocalDate date) {

        return this.testCaseRepository.findAllSinceDate(date).stream()
                .map(testCase -> mapper.map(testCase, ResTestCaseDto.class)).toList();
    }
}
