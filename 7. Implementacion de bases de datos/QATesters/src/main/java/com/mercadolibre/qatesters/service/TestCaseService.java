package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.request.TestCaseReqDto;
import com.mercadolibre.qatesters.dto.request.TestIdDto;
import com.mercadolibre.qatesters.dto.response.MessageDto;
import com.mercadolibre.qatesters.dto.response.TestCaseResDto;
import com.mercadolibre.qatesters.entity.TestCase;
import com.mercadolibre.qatesters.exception.NotFoundException;
import com.mercadolibre.qatesters.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {
    private final ITestRepository testRepository;

    private final ModelMapper mapper = new ModelMapper();

    public TestCaseService(ITestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public MessageDto saveTestCase(TestCaseReqDto testCaseReqDto) {
        testRepository.save(mapper.map(testCaseReqDto, TestCase.class));
        return new MessageDto("Se creo un nuevo testCase");
    }
    @Override
    public TestCaseResDto findTestCaseById(TestIdDto testIdDto) {
        TestCase testCase = testRepository.findById(testIdDto.getId()).orElseThrow(() -> new NotFoundException("No se encontro el testCase"));
        return mapper.map(testCase, TestCaseResDto.class);
    }

    @Override
    public List<TestCaseResDto> findAllTestCases() {
        List<TestCase> testCases = testRepository.findAll();
        return mapper.map(testCases, new TypeToken<List<TestCaseResDto>>() {}.getType());
    }

    @Override
    public MessageDto updateTestCaseById(TestIdDto testIdDto, TestCaseReqDto testCaseReqDto) {
        TestCase testCase = testRepository.findById(testIdDto.getId()).orElseThrow(() -> new NotFoundException("No se encontro el testCase"));
        mapper.map(testCaseReqDto, testCase);

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
    public List<TestCaseResDto> findTestCaseByLastUpdate(LocalDate lastUpdate) {
        return mapper.map(testRepository.findAllByLastUpdateAfter(lastUpdate), new TypeToken<List<TestCaseResDto>>() {}.getType());
    }
}
