package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.TestCaseDTO;
import com.example.ejemplo_jpa.dto.UpdateTestCaseDTO;
import com.example.ejemplo_jpa.model.TestCase;
import com.example.ejemplo_jpa.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final ModelMapper mapper =
            new ModelMapper()
                    /*.configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)*/;

    private final TestCaseRepository testCaseRepository;

 //Si implemento con constructor es así:
    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    @Transactional (readOnly = true)
    public List<TestCaseDTO> getTestCases() {
        List<TestCase> jewelList = testCaseRepository.findAll();
        return mapper.map(
                jewelList,
                new TypeToken<List<TestCaseDTO>>() {}.getType()
        );
    }

    @Override
    @Transactional
    public void saveTestCase(TestCaseDTO testCaseDTO) {
        testCaseRepository.save(mapper.map(testCaseDTO, TestCase.class));
    }

    @Override
    @Transactional
    public void deleteTestCase(long id) {
        testCaseRepository.deleteById(id);
    }


    @Override
    @Transactional (readOnly = true)
    public TestCaseDTO findTestCase(long id) {
        return mapper.map(
                testCaseRepository.findById(id).get(),
                TestCaseDTO.class
                );
    }

    @Override
    public void updateTestCase(long id, UpdateTestCaseDTO updateTestCaseDTO) {
        //Faltan manejar errores
        TestCase testCase = testCaseRepository.findById(id).get();

        mapper.map(updateTestCaseDTO, testCase);

        testCaseRepository.save(testCase);

    }

    @Override
    public List<TestCaseDTO> findTestCasesUpdatedAfterDate(LocalDate last_update) {
        return mapper.map(
                testCaseRepository.findByLastUpdateAfter(last_update),
                new TypeToken<List<TestCaseDTO>>() {}.getType()
        );
        /*return mapper.map(
                testCaseRepository
                .findAll()
                .stream()
                .filter(t -> t.getLast_update().isAfter(lastUpdate))
                .toList(),
                new TypeToken<List<TestCaseDTO>>() {}.getType()
                );*/

    }
}



