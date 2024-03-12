package com.bootcamp.QA_testers.service;

import com.bootcamp.QA_testers.dto.request.TestCaseReqDTO;
import com.bootcamp.QA_testers.dto.response.TestCaseResDTO;
import com.bootcamp.QA_testers.model.TestCase;
import com.bootcamp.QA_testers.repository.ITestCaseRepository;
import com.bootcamp.QA_testers.util.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImp implements ITestCaseService {
    private final ITestCaseRepository repository;

    public TestCaseServiceImp(ITestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestCaseResDTO findTestCase(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        if (testCase.isEmpty())
            throw new RuntimeException("No se ha encontrado el test con ID: " + id);
        return Mapper.entityToDTO(testCase.get());
    }

    @Override
    public void deleteTestCase(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        if (testCase.isEmpty())
            throw new RuntimeException("No se puede eliminar el test con ID: " + id + " porque no existe.");
        repository.deleteById(id);
    }

    @Override
    public TestCaseResDTO saveTestCase(TestCaseReqDTO testCase) {
        TestCase newTestCase = Mapper.dtoToEntity(testCase);
        return Mapper.entityToDTO(repository.save(newTestCase));
    }

    @Override
    public List<TestCaseResDTO> findAll() {
        List<TestCase> testCases = repository.findAll();
        return testCases.stream()
                .map(Mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseResDTO modifyTestCase(Long id, TestCaseReqDTO testCase) {
        Optional<TestCase> optTest = repository.findById(id);

        if (optTest.isEmpty()) {
            throw new RuntimeException("El test con id " + id + " no puede ser modificado ya que no existe.");
        }

        optTest = Optional.of(Mapper.dtoToEntity(testCase));
        optTest.get().setLastUpdate(LocalDate.now());
        optTest.get().setId(id);

        return Mapper.entityToDTO(repository.save(optTest.get()));
    }

    @Override
    public List<TestCaseResDTO> findTestCasesAfterDate(LocalDate date){
        return repository.findByLastUpdateAfter(date)
                .stream().map(Mapper::entityToDTO).toList();
    }
}
