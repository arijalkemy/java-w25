package com.example.qatesters.service;

import com.example.qatesters.dto.GenericResponseDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.dto.TestCaseRequestDTO;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
  ITestCaseRepository testCaseRepository;
  ModelMapper modelMapper;

  public TestCaseServiceImpl(ITestCaseRepository testCaseRepository, ModelMapper modelMapper) {
    this.testCaseRepository = testCaseRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public TestCaseDTO createTestCase(TestCaseRequestDTO testCaseDTO) {
    TestCase createdTestCase = testCaseRepository.save(modelMapper.map(testCaseDTO,TestCase.class));

    return modelMapper.map(createdTestCase,TestCaseDTO.class);
  }

  @Override
  public List<TestCaseDTO> getAllTestCases() {
    List<TestCase> testCases = testCaseRepository.findAll();

    return testCases.stream().map(tc ->
      modelMapper.map(tc,TestCaseDTO.class)
    ).toList();
  }

  @Override
  public TestCaseDTO getTestCaseById(Long id) {
    TestCase testCase = testCaseRepository.findById(id).orElseThrow();

    return modelMapper.map(testCase, TestCaseDTO.class);
  }

  @Override
  public TestCaseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseDTO) {
    TestCase testCaseToUpdate = testCaseRepository.findById(id).orElseThrow();

    if (testCaseDTO.getTested() != null) {
      testCaseToUpdate.setTested(testCaseDTO.getTested());
    }
    if (testCaseDTO.getPassed() != null) {
      testCaseToUpdate.setPassed(testCaseDTO.getPassed());
    }
    if (testCaseDTO.getDescription() != null) {
      testCaseToUpdate.setDescription(testCaseDTO.getDescription());
    }
    if (testCaseDTO.getNumber_of_tries() != null) {
      testCaseToUpdate.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
    }
    testCaseToUpdate.setLast_update(LocalDate.now());

    return modelMapper.map(testCaseRepository.save(testCaseToUpdate),TestCaseDTO.class);
  }

  @Override
  public GenericResponseDTO deleteTestCase(Long id) {
    testCaseRepository.deleteById(id);
    return new GenericResponseDTO(HttpStatus.OK.value(), "Test case eliminado con éxito id: " + id);
  }
}
