package com.nq.testcases.service;

import com.nq.testcases.dto.TestCaseRequestDTO;
import com.nq.testcases.dto.TestCaseResponseDTO;
import com.nq.testcases.dto.TestCaseResponseIdDTO;
import com.nq.testcases.entity.TestCase;
import com.nq.testcases.exception.NotFoundException;
import com.nq.testcases.repository.TestCaseRepository;
import com.nq.testcases.utils.CustomMapper;
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
    public TestCaseResponseIdDTO createTestCase(TestCaseRequestDTO newTestCase) {
        TestCase testCase = CustomMapper.testCaseRequestToTestCase(newTestCase);
        TestCase testCaseInBD = testCaseRepository.save(testCase);
        return CustomMapper.testCaseToTestCaseResponseId(testCaseInBD);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseIdDTO> getAllTestCases() {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        return testCaseList.stream()
                .map(CustomMapper::testCaseToTestCaseResponseId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseIdDTO> getAllTestCasesWithLastUpdateAfter(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepository.findByLastUpdateAfter(date);
        return testCaseList.stream()
                .map(CustomMapper::testCaseToTestCaseResponseId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseIdDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return CustomMapper.testCaseToTestCaseResponseId(testCase);
    }

    @Override
    @Transactional
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO updatedTestCase) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null)
            throw new NotFoundException(id.toString());
        testCase.setDescription(updatedTestCase.description());
        testCase.setTested(updatedTestCase.tested());
        testCase.setPassed(updatedTestCase.passed());
        testCase.setNumberOfTries(updatedTestCase.numberOfTries());

        testCaseRepository.save(testCase);
        return CustomMapper.testCaseToTestCaseResponse(testCase);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        if (!this.testCaseRepository.existsById(id)) {
            throw new NotFoundException(id.toString());
        }
        this.testCaseRepository.deleteById(id);
    }

}
