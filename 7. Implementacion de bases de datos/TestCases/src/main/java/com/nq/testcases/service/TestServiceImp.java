package com.nq.testcases.service;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseDTO;
import com.nq.testcases.entity.TestCase;
import com.nq.testcases.exception.NotFoundException;
import com.nq.testcases.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImp implements TestService {

    private final TestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    public TestServiceImp(TestCaseRepository testCaseRepository, ModelMapper mapperUtil) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = mapperUtil;
    }

    @Override
    @Transactional
    public TestCaseResponseDTO createTestCase(TestCaseRequestDTO newTestCase) {
        TestCase testCase = modelMapper.map(newTestCase, TestCase.class);
        TestCase testCaseInBD = testCaseRepository.save(testCase);
        return modelMapper.map(testCaseInBD, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDTO> getAllTestCases() {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        return testCaseList.stream()
                .map(test -> modelMapper.map(test, TestCaseResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDTO> getAllTestCasesWithLastUpdateAfter(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepository.findAllByLastUpdateAfter(date);
        return testCaseList.stream()
                .map(test -> modelMapper.map(test, TestCaseResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional (readOnly = true)
    public TestCaseResponseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return modelMapper.map(testCase, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO updatedTestCase) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null)
            throw new NotFoundException(id.toString());
        testCase.setDescription(updatedTestCase.getDescription());
        testCase.setTested(updatedTestCase.getTested());
        testCase.setPassed(updatedTestCase.getPassed());
        testCase.setNumberOfTries(updatedTestCase.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.now());
        testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        if (!this.testCaseRepository.existsById(id)){
            throw new NotFoundException(id.toString());
        }
        this.testCaseRepository.deleteById(id);
    }

}
