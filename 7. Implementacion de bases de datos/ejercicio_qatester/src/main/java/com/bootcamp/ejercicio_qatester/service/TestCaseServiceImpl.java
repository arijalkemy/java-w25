package com.bootcamp.ejercicio_qatester.service;

import com.bootcamp.ejercicio_qatester.Exceptions.NotFoundException;
import com.bootcamp.ejercicio_qatester.dto.request.TestCaseDTO;
import com.bootcamp.ejercicio_qatester.dto.response.GenericResponseDTO;
import com.bootcamp.ejercicio_qatester.model.TestCase;
import com.bootcamp.ejercicio_qatester.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }


    @Override
    public TestCaseDTO createTestCase(TestCaseDTO testCase) {
        System.out.println(testCase);
        ModelMapper modelMapper = new ModelMapper();
        TestCase newTestCase = modelMapper.map(testCase, TestCase.class);
        System.out.println(newTestCase);
        testCaseRepository.save(newTestCase);
        return testCase;
    }

    @Override
    public List<TestCaseDTO> getAll(String last_update) {
        if (last_update == null) {
            ModelMapper modelMapper = new ModelMapper();
            return this.testCaseRepository.findAll().stream().map(testCase -> modelMapper.map(testCase, TestCaseDTO.class)).toList();
        }
        else {
            return this.getTestCaseByDates(LocalDate.parse(last_update, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        TestCase test = this.testCaseRepository.findById(id).orElseThrow(() ->
        {
            return new NotFoundException("el id no corresponde a ningun TestCase");
        });
        return new ModelMapper().map(test, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCase) {
        this.testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TestCase not found with id: " + id));

        ModelMapper modelMapper = new ModelMapper();
        TestCase testCaseUpdated = modelMapper.map(testCase, TestCase.class);
        testCaseUpdated.setId_case(id);
        TestCase testCaseToUpdate = this.testCaseRepository.save(testCaseUpdated);
        return modelMapper.map(testCaseToUpdate, TestCaseDTO.class);
    }

    @Override
    public GenericResponseDTO deleteTestCase(Long id) {
        TestCase testCase = this.testCaseRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException("el id no corresponde a ningun TestCase");
        });
        this.testCaseRepository.delete(testCase);
        return new GenericResponseDTO("El test case fue borrado con exito");
    }

    @Override
    public List<TestCaseDTO> getTestCaseByDates(LocalDate last_update) {
        ModelMapper modelMapper = new ModelMapper();
        return this.testCaseRepository
                .findAll().stream()
                .filter(testCase -> {
                    if (testCase.getLast_update() == null) {
                        return false;
                    } else {
                        return testCase.getLast_update()
                                .isAfter(last_update);
                    }
                })
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }
}
