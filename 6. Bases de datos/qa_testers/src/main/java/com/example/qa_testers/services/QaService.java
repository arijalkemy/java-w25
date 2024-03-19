package com.example.qa_testers.services;

import com.example.qa_testers.dtos.RequestTestCaseDto;
import com.example.qa_testers.dtos.ResponseTestCaseDto;
import com.example.qa_testers.entities.TestCase;
import com.example.qa_testers.exceptions.NotFoundException;
import com.example.qa_testers.repositories.QaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class QaService implements IQaService{

    private final QaRepository repository;

    public QaService (QaRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<TestCase> getAll(LocalDate date) {

        if (date == null) {
            return repository.findAll();
        }


        List<TestCase> testCases = repository.findAll().stream().filter(testCase -> testCase.getLastUpdate().isAfter(date)).toList();
        return testCases;

    }

    @Override
    @Transactional
    public ResponseTestCaseDto getById(Long id){
        TestCase testCase = repository.findById(id).orElseThrow(() -> new NotFoundException("TestCase con id: "+id+" no encontrado."));
        return new ResponseTestCaseDto(testCase.getIdCase(), testCase.getDescription(), testCase.getTested(), testCase.getPassed(), testCase.getNumberOfTries(), testCase.getLastUpdate().toString());
    }

    @Override
    public ResponseTestCaseDto updateById(Long id, RequestTestCaseDto requestTestCaseDto) {
        TestCase testCase = repository.findById(id).orElseThrow(() -> new NotFoundException("TestCase con id: "+id+" no encontrado."));
        testCase.setDescription(requestTestCaseDto.getDescription());
        testCase.setTested(requestTestCaseDto.getTested());
        testCase.setPassed(requestTestCaseDto.getPassed());
        testCase.setNumberOfTries(requestTestCaseDto.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.parse(requestTestCaseDto.getLastUpdate()));
        repository.save(testCase);
        return new ResponseTestCaseDto(testCase.getIdCase(), testCase.getDescription(), testCase.getTested(), testCase.getPassed(), testCase.getNumberOfTries(), testCase.getLastUpdate().toString());
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        getById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseTestCaseDto saveTestCase(RequestTestCaseDto requestTestCase){
        TestCase testCase = repository.save(testDtoToEntity(requestTestCase));
        return new ResponseTestCaseDto(testCase.getIdCase(), testCase.getDescription(), testCase.getTested(), testCase.getPassed(), testCase.getNumberOfTries(), testCase.getLastUpdate().toString());
    }

    private TestCase testDtoToEntity(RequestTestCaseDto dto){
        TestCase testCase = new TestCase();
        testCase.setDescription(dto.getDescription());
        testCase.setTested(dto.getTested());
        testCase.setPassed(dto.getPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.parse(dto.getLastUpdate()));
        return testCase;
    }
}
