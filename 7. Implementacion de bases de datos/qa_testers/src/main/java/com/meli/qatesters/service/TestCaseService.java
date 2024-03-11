package com.meli.qatesters.service;

import com.meli.qatesters.dto.CreateTestCaseDto;
import com.meli.qatesters.dto.ResTestCaseDto;
import com.meli.qatesters.dto.ResponseMessageDto;
import com.meli.qatesters.exception.NotFoundException;
import com.meli.qatesters.model.TestCase;
import com.meli.qatesters.repository.ITestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository repository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public ResTestCaseDto createTestCase(CreateTestCaseDto createTestCaseDto) {
        TestCase newTestCase = mapper.map(createTestCaseDto, TestCase.class);
        return mapper.map(repository.save(newTestCase), ResTestCaseDto.class);
    }
    @Override
    public List<ResTestCaseDto> getAllTestCases() {
        return repository.findAll().stream()
                .map(test -> mapper.map(test, ResTestCaseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResTestCaseDto getTestCase(Long id) {
        return mapper.map(
                repository.findById(id)
                        .orElseThrow(() -> new NotFoundException("TestCase "+id+" not found.")),
                ResTestCaseDto.class
        );
    }


    public ResTestCaseDto updateTestCase(Long id, CreateTestCaseDto testUp) {
        TestCase test = repository.findById(id)
                .orElseThrow( ()->new NotFoundException("TestCase "+id+" not found."));

        if (testUp.getDescription() != null) {
            test.setDescription(testUp.getDescription());
        }
        if (testUp.getTested() != null) {
            test.setTested(testUp.getTested());
        }
        if (testUp.getPassed() != null) {
            test.setPassed(testUp.getPassed());
        }
        if (testUp.getNumberOfTries() != 0) {
            test.setNumberOfTries(testUp.getNumberOfTries());
        }
        if (testUp.getLastUpdate() != null) {
            test.setLastUpdate(testUp.getLastUpdate());
        }

        repository.save(test);

        return mapper.map(test, ResTestCaseDto.class);
    }


    public ResponseMessageDto deleteTestCase(Long id) {
        repository.deleteById(id);
        return new ResponseMessageDto("TestCase " + id + " deleted succesfuly.");
    }

    @Override
    public List<ResTestCaseDto> getAllTestCasesAfterDate(LocalDate date){
        return repository.findByLastUpdateAfter(date).stream()
                .map(testCase -> mapper.map(testCase, ResTestCaseDto.class))
                .toList();
    }
}
