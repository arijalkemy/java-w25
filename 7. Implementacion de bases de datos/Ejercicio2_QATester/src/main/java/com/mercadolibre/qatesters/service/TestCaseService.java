package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.MessageDto;
import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.dto.TestIdDto;
import com.mercadolibre.qatesters.entity.TestCase;
import com.mercadolibre.qatesters.exception.NotFoundException;
import com.mercadolibre.qatesters.repository.ITestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final ITestRepository testRepository;

    @Override
    public MessageDto saveTestCase(TestCaseDto testCaseDto) {
        testRepository.save(new TestCase(testCaseDto));
        return new MessageDto("Se creo un nuevo testCase");
    }
    @Override
    public TestCaseDto searchTestCaseById(TestIdDto id) {
        TestCase testCase = testRepository.findById(id.getId()).orElseThrow(() -> new NotFoundException("No se encontro el testCase"));
        return new TestCaseDto(testCase);
    }

    @Override
    public List<TestCaseDto> searchAllTestCases() {
        List<TestCase> testCases = testRepository.findAll();
        List<TestCaseDto> testCasesList = testCases.stream()
                .map(this::convertTestcaseToDto)
                .toList();

        return testCasesList;
    }

    @Override
    public MessageDto updateTestCaseById(TestIdDto testIdDto, TestCaseDto testCaseDto) {
        TestCase testCase = testRepository.findById(testIdDto.getId()).orElseThrow(() -> new NotFoundException("No se encontro el testCase"));
        if (testCaseDto.getDescription()) testCase.setDescription(testCaseDto.getDescription());
        if (testCaseDto.getTested()) testCase.setTested(testCaseDto.getTested());
        if (testCaseDto.getPassed()) testCase.setPassed(testCaseDto.getPassed());
        if (testCaseDto.getNumberOfTries() != null) testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.now());

        testRepository.save(testCase);
        return new MessageDto("Se actualizo el testCase");
    }

    @Override
    public MessageDto deleteTestCaseById(TestIdDto idDto) {
        Long testCaseId = idDto.getId();
        testRepository.findById(testCaseId).orElseThrow(()-> new NotFoundException("No se encontró el testCase con el ID: " + testCaseId));
        testRepository.deleteById(testCaseId);
        return new MessageDto("Se elimino el testCase con el ID: " + testCaseId);
    }

    @Override
    public List<TestCaseDto> searchTestCaseByLastUpdate(LocalDate lastUpdate) {
        List<TestCaseDto> testCaseDtos =new ArrayList<>();
        List<TestCase> testCases = testRepository.findAllByLastUpdateAfter(lastUpdate);
        testCases.forEach(testCase -> testCaseDtos.add(new TestCaseDto(testCase)));
        return testCaseDtos;
    }

    private TestCaseDto convertTestcaseToDto(TestCase t) {
        return new TestCaseDto(
            t.getDescription(),
            t.getTested(),
            t.getPassed(),
            t.getNumberOfTries(),
            t.getLastUpdate());
    }
}
