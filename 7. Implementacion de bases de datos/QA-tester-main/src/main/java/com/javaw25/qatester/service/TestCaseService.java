package com.javaw25.qatester.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.javaw25.qatester.dto.TestCaseDto;
import com.javaw25.qatester.dto.TestCaseDtoMixin;
import com.javaw25.qatester.dto.request.CreateTestCaseDto;
import com.javaw25.qatester.exception.NotFoundException;
import com.javaw25.qatester.model.TestCase;
import com.javaw25.qatester.repository.ITestCaseRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService implements ITestCaseService{
    private ITestCaseRepository testCaseRepo;
    private ObjectMapper mapper;

    public TestCaseService(ITestCaseRepository testCaseRepo) {
        this.testCaseRepo = testCaseRepo;
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.addMixIn(TestCase.class, TestCaseDtoMixin.class);
    }

    @Override
    public TestCaseDto updateTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);
        this.testCaseRepo.save(testCase);
        TestCase updatedTestCase = this.testCaseRepo.findById(testCase.getId_case()).orElse(null);
        TestCaseDto updatedTestCaseDto = mapper.convertValue(updatedTestCase, TestCaseDto.class);
        return updatedTestCaseDto;
    }

    @Override
    public void deleteTestCase(Long id) {
        this.getTestCaseById(id);
        this.testCaseRepo.deleteById(id);
    }

    private boolean compareDates(LocalDate date1, LocalDate date2){
        long compDate = ChronoUnit.DAYS.between(date1, date2);
        double compDateWeeks = compDate/7.0;
        return compDateWeeks >= 0  && compDateWeeks <= 2.0;
    }

    @Override
    public List<TestCaseDto> getTestCases(String date) {
        List<TestCase> testCaseList;
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            testCaseList = testCaseRepo.findAll()
                    .stream().filter(testCase -> compareDates(localDate, testCase.getLast_update()))
                    .toList();
        }else {
            testCaseList = testCaseRepo.findAll();
        }

        List<TestCaseDto> testCaseDtoList = testCaseList
                .stream().map(
                        testCase -> mapper.convertValue(testCase, TestCaseDto.class))
                .toList();
        return testCaseDtoList;
    }


    @Override
    public TestCaseDto getTestCaseById(Long id) {
        TestCase testCase = testCaseRepo.findById(id).orElse(null);
        if (testCase == null)
            throw new NotFoundException("Caso de prueba no encontrado.");
        TestCaseDto testCaseDto = mapper.convertValue(testCase, TestCaseDto.class);
        return testCaseDto;
    }

    @Override
    public TestCaseDto createTestCase(CreateTestCaseDto testCaseToCreate) {
        TestCase testCase = mapper.convertValue(testCaseToCreate, TestCase.class);
        this.testCaseRepo.save(testCase);
        return mapper.convertValue(testCase, TestCaseDto.class);
    }
}
