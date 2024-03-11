package com.example.bootcamp.services;

import com.example.bootcamp.dto.request.TestCaseDTO;
import com.example.bootcamp.dto.response.TestCaseDTOResponse;
import com.example.bootcamp.exceptions.NotFoundException;
import com.example.bootcamp.model.TestCase;
import com.example.bootcamp.repositories.ITestCaseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImp implements ITestCaseService{

    @Autowired
    private ITestCaseRepository testCaseRepository;

    private ModelMapper mapper = new ModelMapper();
    @Override
    public TestCaseDTOResponse findById(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if(testCase.isEmpty()) throw new NotFoundException("No se encontró el test solicitado");
        return mapper.map(testCase.get(), TestCaseDTOResponse.class);
    }

    @Override
    public void delete(Long id) {
        TestCase test = testCaseRepository.findById(id).orElse(null);
        if (test != null || test.isActivo()) testCaseRepository.delete(test);
        else throw new NotFoundException("No se encontró el test solicitado");
    }

    @Override
    public TestCaseDTOResponse create(TestCaseDTO testCaseDTO) {
        TestCase  newTest = mapper.map(testCaseDTO, TestCase.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(testCaseDTO.getLast_update(), formatter);
        newTest.setLast_update(fecha);
        testCaseRepository.save(newTest);
        return mapper.map(newTest, TestCaseDTOResponse.class); // funciona excelente (?
    }

    @Override
    public TestCase update(Long id, TestCaseDTO testCaseDTO) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);

        if(testCase.isPresent()){
            TestCase testToUpdate = testCase.get();
            testToUpdate.setDescription(testCaseDTO.getDescription());
            testToUpdate.setTested(true);
            testToUpdate.setPassed(true);
            testToUpdate.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
            testToUpdate.setLast_update(LocalDate.now());
            testToUpdate.setActivo(true);

            return testToUpdate;
        }
        throw new NotFoundException("No se encontraró el test con id: '" + id + "'.");
    }

    @Override
    public List<TestCaseDTOResponse> findAll(String last_update) {
        List<TestCase> testCases = findTestCases(last_update);
        if(testCases.isEmpty()) throw new NotFoundException("No se encontraron tests almacenados");
        ObjectMapper objectMapper = new ObjectMapper();
        List<TestCaseDTOResponse> testCaseDTOResponses = objectMapper
                .convertValue(testCases, new TypeReference<List<TestCaseDTOResponse>>() {});
        return testCaseDTOResponses;
    }

    private List<TestCase> findTestCases(String last_update){
        List<TestCase> testCases;
        if(last_update.isBlank()) testCases = testCaseRepository.findAll();
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(last_update, formatter);
            // testCases = testCaseRepository.findByLast_update(fecha);
            testCases = List.of();
        }
        return testCases;
    }
    
}
