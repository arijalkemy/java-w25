package com.implementacionbasedatos.ejercicio1.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.implementacionbasedatos.ejercicio1.dto.req.TestCaseReqDTO;
import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDTO;
import com.implementacionbasedatos.ejercicio1.dto.res.TestCaseResDTO;
import com.implementacionbasedatos.ejercicio1.exception.NotFoundException;
import com.implementacionbasedatos.ejercicio1.model.TestCase;
import com.implementacionbasedatos.ejercicio1.repository.ITestCaseRepository;

import org.springframework.stereotype.Service;

@Service
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository iTestCaseRepository;

    public TestCaseService(ITestCaseRepository iTestCaseRepository) {
        this.iTestCaseRepository = iTestCaseRepository;
    }

    private TestCase TestCaseReqDTOToModel(TestCaseReqDTO testCaseReqDTO) {
        return new TestCase(testCaseReqDTO.getIdCase(), testCaseReqDTO.getDescription(), testCaseReqDTO.getTested(),
                testCaseReqDTO.getPassed(), testCaseReqDTO.getNumberOfTries(), testCaseReqDTO.getLastUpdate());
    }

    private TestCaseReqDTO TestCaseResDTOToReqDTO(TestCaseResDTO testCaseResDTO) {
        return new TestCaseReqDTO(testCaseResDTO.getIdCase(), testCaseResDTO.getDescription(),
                testCaseResDTO.getTested(),
                testCaseResDTO.getPassed(), testCaseResDTO.getNumberOfTries(), testCaseResDTO.getLastUpdate());
    }

    private TestCaseResDTO TestCaseModelToResDTO(TestCase TestCase) {
        return new TestCaseResDTO(TestCase.getIdCase(), TestCase.getDescription(), TestCase.getTested(),
                TestCase.getPassed(), TestCase.getNumberOfTries(), TestCase.getLastUpdate());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResDTO> getTestCase() {
        List<TestCase> TestCaseList = iTestCaseRepository.findAll();
        List<TestCaseResDTO> TestCaseListDTO = new ArrayList<>();
        for (TestCase e : TestCaseList) {
            TestCaseListDTO.add(TestCaseModelToResDTO(e));
        }
        return TestCaseListDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResDTO getTestCaseById(long id) {
        TestCase TestCase = iTestCaseRepository.findById(id).orElse(null);
        if (TestCase == null) {
            throw new NotFoundException("No se encontró ningun TestCase con el id indicado.");
        }
        return TestCaseModelToResDTO(TestCase);
    }

    @Override
    @Transactional
    public MessageResDTO postTestCase(TestCaseReqDTO testCaseReqDTO) {
        iTestCaseRepository.save(TestCaseReqDTOToModel(testCaseReqDTO));
        return new MessageResDTO("El TestCase fue agregada correctamente");
    }

    @Override
    @Transactional
    public MessageResDTO deleteTestCase(long id) {
        TestCase miniSerie = iTestCaseRepository.findById(id).orElse(null);
        if (miniSerie == null) {
            throw new NotFoundException("No se encontró ningun TestCase con el id indicado.");
        }
        iTestCaseRepository.deleteById(id);
        return new MessageResDTO("El TestCase fue borrado correctamente");
    }

    @Override
    @Transactional
    public TestCaseResDTO putTestCase(Long id, TestCaseReqDTO testCaseReqDTO) {
        TestCaseResDTO TestCaseFound = this.getTestCaseById(id);
        TestCaseFound.setDescription(testCaseReqDTO.getDescription());
        TestCaseFound.setLastUpdate(testCaseReqDTO.getLastUpdate());
        TestCaseFound.setNumberOfTries(testCaseReqDTO.getNumberOfTries());
        TestCaseFound.setPassed(testCaseReqDTO.getPassed());
        TestCaseFound.setTested(testCaseReqDTO.getTested());
        this.postTestCase(TestCaseResDTOToReqDTO(TestCaseFound));
        return TestCaseFound;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResDTO> getLastUpdates(String lastUpdate) {
        LocalDate lastUpdateLD = LocalDate.now();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            lastUpdateLD = LocalDate.parse(lastUpdate, formatter);
        } catch (Exception e) {
            throw new NotFoundException("El formato de fecha es inválido. El formato correcto es yyyy-MM-dd.");
        }
        List<TestCase> TestCaseList = iTestCaseRepository.findAll();
        List<TestCaseResDTO> TestCaseListDTO = new ArrayList<>();
        for (TestCase e : TestCaseList) {
            if (e.getLastUpdate().isAfter(lastUpdateLD)) {
                TestCaseListDTO.add(TestCaseModelToResDTO(e));
            }
        }
        return TestCaseListDTO;
    }
}
