package com.qatesters.qatesters.service;

import com.qatesters.qatesters.Exceptions.NotFoundException;
import com.qatesters.qatesters.dto.request.TestcaseDTO;
import com.qatesters.qatesters.dto.response.GenericResponseDTO;
import com.qatesters.qatesters.model.Testcase;
import com.qatesters.qatesters.repository.ITestcaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestcaseService implements ITestcaseService{
    @Autowired
    ITestcaseRepository testcaseRepository;

    @Override
    public TestcaseDTO createTestcase(TestcaseDTO testcaseDTO) {
        ModelMapper mapper=new ModelMapper();

        Testcase testcase= mapper.map(testcaseDTO, Testcase.class);

        testcaseRepository.save(testcase);

        return testcaseDTO;
    }

    @Override
    public List<TestcaseDTO> getAll(String lastUpdated) {
        if(lastUpdated==null){
            ModelMapper mapper=new ModelMapper();
            return testcaseRepository.findAll().stream().map(testcase -> mapper.map(testcase, TestcaseDTO.class)).toList();
        }else{
            return this.getTestcaseByDate(LocalDate.parse(lastUpdated, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    @Override
    public TestcaseDTO getTestcaseById(Long id) {
        Testcase testcase = testcaseRepository.findById(id).orElseThrow(() -> new NotFoundException("el id no corresponde a ningun TestCase"));

        return new ModelMapper().map(testcase, TestcaseDTO.class);
    }

    @Override
    public TestcaseDTO updateTestcase(Long id, TestcaseDTO testcaseDTO) {
        testcaseRepository.findById(id).orElseThrow(()-> new NotFoundException("el id no corresponde a ningun TestCase"));

        ModelMapper mapper=new ModelMapper();

        Testcase newDataTestcase=mapper.map(testcaseDTO, Testcase.class);

        newDataTestcase.setIdCase(id);

        Testcase testcaseUpdated=testcaseRepository.save(newDataTestcase);

        return mapper.map(testcaseUpdated, TestcaseDTO.class);
    }

    @Override
    public GenericResponseDTO deleteTestcase(Long id) {
        testcaseRepository.findById(id).orElseThrow(()-> new NotFoundException("el id no corresponde a ningun TestCase"));

        testcaseRepository.deleteById(id);

        return new GenericResponseDTO("Test eliminado exitosamente");
    }

    @Override
    public List<TestcaseDTO> getTestcaseByDate(LocalDate lastUpdated) {
        ModelMapper mapper = new ModelMapper();
        return testcaseRepository
                .findAll().stream()
                .filter(testCase -> {
                    if (testCase.getLastUpdated() == null) {
                        return false;
                    } else {
                        return testCase.getLastUpdated()
                                .isAfter(lastUpdated);
                    }
                })
                .map(testCase -> mapper.map(testCase, TestcaseDTO.class))
                .toList();
    }
}
