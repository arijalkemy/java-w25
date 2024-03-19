package com.QATesters.service;

import com.QATesters.dto.request.RequestTestCaseDto;
import com.QATesters.dto.response.MessageDto;
import com.QATesters.dto.response.TestCaseDto;
import com.QATesters.exception.NotFoundException;
import com.QATesters.model.TestCase;
import com.QATesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository, ModelMapper modelMapper) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional (readOnly = true)
    public List<TestCaseDto> getTestCases(String lastUpdate) {
        if(lastUpdate != null){
            return this.getTestCasesByLastUpdated(lastUpdate);
        }
        return testCaseRepository.findAll().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDto.class))
                .toList();
    }

    @Override
    @Transactional
    public MessageDto createTestCase(RequestTestCaseDto createTestCaseDto) {

        LocalDate lastUpdate = LocalDate.parse(createTestCaseDto.getLastUpdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        TestCase newCase = modelMapper.map(createTestCaseDto, TestCase.class);
        newCase.setLastUpdate(lastUpdate);
        testCaseRepository.save(newCase);

        return new MessageDto("Caso de prueba ha sido creado con exito");
    }

    @Override
    @Transactional
    public MessageDto deleteTestCase(Long id) {
        this.getTestCaseById(id);
        testCaseRepository.deleteById(id);
        return new MessageDto("Caso de prueba ha sido eliminado con exito");
    }

    @Override
    @Transactional (readOnly = true)
    public TestCaseDto getTestCaseById(Long id) {
        return modelMapper.map(testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro el caso de prueba")), TestCaseDto.class);
    }

    @Override
    @Transactional
    public MessageDto updateTestCase(Long id, RequestTestCaseDto requestTestCaseDto) {

        LocalDate lastUpdate = LocalDate.parse(requestTestCaseDto.getLastUpdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        TestCase testCase = modelMapper.map(this.getTestCaseById(id), TestCase.class);
        TestCase updateTestCase = modelMapper.map(requestTestCaseDto, TestCase.class);

        updateTestCase.setIdCase(id);
        updateTestCase.setLastUpdate(lastUpdate);
        updateTestCase.setDescription(updateTestCase.getDescription() != null ? updateTestCase.getDescription() : testCase.getDescription());
        updateTestCase.setTested(updateTestCase.getTested() != null ? updateTestCase.getTested() : testCase.getTested());
        updateTestCase.setPassed(updateTestCase.getPassed() != null ? updateTestCase.getPassed() : testCase.getPassed());
        updateTestCase.setNumberOfTries(updateTestCase.getNumberOfTries() != null ? updateTestCase.getNumberOfTries() : testCase.getNumberOfTries());

        testCaseRepository.save(updateTestCase);

        return new MessageDto("Caso de prueba ha sido actualizado con exito");
    }

    private List<TestCaseDto> getTestCasesByLastUpdated(String lastUpdate) {

        LocalDate searchedDate = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return testCaseRepository.findAll().stream()
                .filter(t -> t.getLastUpdate().isAfter(searchedDate))
                .map(testCase -> modelMapper.map(testCase, TestCaseDto.class))
                .toList();
    }
}
