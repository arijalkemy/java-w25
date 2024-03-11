package com.example.qa_testers.service;

import com.example.qa_testers.dto.request.UpsertTestCaseDTO;
import com.example.qa_testers.dto.response.MessageDTO;
import com.example.qa_testers.dto.response.TestCaseDTO;
import com.example.qa_testers.entity.TestCase;
import com.example.qa_testers.exception.BadRequestException;
import com.example.qa_testers.exception.NotFoundException;
import com.example.qa_testers.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImp implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    public TestCaseServiceImp(ITestCaseRepository testCaseRepository, ObjectMapper objectMapper){
        this.testCaseRepository = testCaseRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public TestCaseDTO create(UpsertTestCaseDTO testCase) {
        TestCase newTestCase = testCaseRepository.save(objectMapper.convertValue(testCase, TestCase.class));
        return objectMapper.convertValue(newTestCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAll() {
        return testCaseRepository.findAll().stream()
                .map(e -> objectMapper.convertValue(e, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO getById(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if (testCase.isEmpty()){
            throw new NotFoundException("Test Case not found");
        }
        return objectMapper.convertValue(testCase.get(), TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO update(Long id, UpsertTestCaseDTO updatedTestCase) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if (testCase.isEmpty()){
            throw new NotFoundException("Test Case not found");
        }
        TestCase testCaseToUpdate = testCase.get();
        testCaseToUpdate.setDescription(updatedTestCase.description());
        testCaseToUpdate.setTested(updatedTestCase.tested());
        testCaseToUpdate.setPassed(updatedTestCase.passed());
        testCaseToUpdate.setNumberOfTries(updatedTestCase.numberOfTries());
        testCaseToUpdate.setLastUpdate(LocalDate.now());
        return objectMapper.convertValue(testCaseRepository.save(testCaseToUpdate), TestCaseDTO.class);
    }

    @Override
    public MessageDTO delete(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if (testCase.isEmpty()){
            throw new NotFoundException("Test Case not found");
        }
        testCaseRepository.delete(testCase.get());
        return new MessageDTO("TestCase deleted");
    }

    @Override
    public List<TestCaseDTO> getAfterUpdateDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate formatDate = LocalDate.parse(date, formatter);
            return testCaseRepository.findAfterLastUpdate(formatDate).stream()
                    .map(e -> objectMapper.convertValue(e, TestCaseDTO.class))
                    .toList();
        } catch (Exception e) {
            throw new BadRequestException("Date format not valid");
        }
    }
}
