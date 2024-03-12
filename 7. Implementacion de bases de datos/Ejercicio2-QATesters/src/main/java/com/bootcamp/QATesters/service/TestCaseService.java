package com.bootcamp.QATesters.service;

import com.bootcamp.QATesters.dto.SucessDTO;
import com.bootcamp.QATesters.dto.TestCaseDTO;
import com.bootcamp.QATesters.exception.NotFoundException;
import com.bootcamp.QATesters.model.TestCase;
import com.bootcamp.QATesters.repository.ItestCaseRepo;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ItestCaseService{
    private final ItestCaseRepo itestCaseRepo;
    private ModelMapper mapper;
    public TestCaseService(ItestCaseRepo itestCaseRepo, ModelMapper mapper){
        this.mapper = mapper;
        this.itestCaseRepo= itestCaseRepo;
    }

    @Override
    @Transactional
    public List<TestCaseDTO> getTestCases() {
        List<TestCase> testCaseList = itestCaseRepo.findAll();
        return testCaseList.stream()
                .map(testCase -> mapper.map(testCase,TestCaseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<TestCaseDTO> getTestCasesByDate(LocalDateTime date) {
        List<TestCase> testCaseList = itestCaseRepo.findByLastUpdateAfter(date);
        if (testCaseList==null){
        throw new NotFoundException("no hay casos despues de la fecha");
        }else{
            return testCaseList.stream()
                    .map(testCase -> mapper.map(testCase,TestCaseDTO.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    @Transactional
    public SucessDTO saveTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        itestCaseRepo.save(testCase);
        return new SucessDTO("Created Successfully");
    }

    @Override
    @Transactional
    public TestCaseDTO findTestCase(long id_case) {
        TestCase testCase = itestCaseRepo.findById(id_case).orElse(null);
        if(testCase == null){
            throw  new NotFoundException("The test case with id" + id_case + "was not found");
        }else {
            return mapper.map(testCase,TestCaseDTO.class);
        }
    }

    @Override
    @Transactional
    public SucessDTO deleteTestCase(Long id) {
        itestCaseRepo.deleteById(id);
            return new SucessDTO("The test case has been deleted successfully");
    }

    @Override
    @Transactional
    public SucessDTO updateTestCase(Long id, TestCaseDTO testCaseDTO){
        TestCaseDTO foundTestCaseDTO = findTestCase(id);
        TestCase foundTestCase = mapper.map(foundTestCaseDTO,TestCase.class);
        if(testCaseDTO.getTested() != null){
            foundTestCase.setTested(testCaseDTO.getTested());
        }
        if(testCaseDTO.getPassed() != null){
            foundTestCase.setPassed(testCaseDTO.getPassed());
        }
        if(testCaseDTO.getNumberOfTries() != null){
            foundTestCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        }
        if(testCaseDTO.getLastUpdate() != null){
            foundTestCase.setLastUpdate(testCaseDTO.getLastUpdate());
        }
        if(testCaseDTO.getDescription() != null){
            foundTestCase.setDescription(testCaseDTO.getDescription());
        }

        itestCaseRepo.save(foundTestCase);
        return new SucessDTO("The test case with id " +id+" was updated successfully");
    }
}
