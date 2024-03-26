package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDto;
import com.example.QATesters.dto.TestCaseRequestDTO;
import com.example.QATesters.dto.TestCaseResponseDto;
import com.example.QATesters.exception.NotFoundException;
import com.example.QATesters.model.TestCase;
import com.example.QATesters.repository.ITestCaseRepository;
import com.example.QATesters.util.Mapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{
    private ITestCaseRepository iTestCaseRepository;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public TestCaseService(ITestCaseRepository iTestCaseRepository){
        this.iTestCaseRepository = iTestCaseRepository;
    }
    @Override
    public TestCaseResponseDto save(TestCaseRequestDTO testCaseRequestDTO){
        TestCase testCase = Mapper.getMapper().map(testCaseRequestDTO,TestCase.class);
        iTestCaseRepository.save(testCase);
        return Mapper.getMapper().map(testCase,TestCaseResponseDto.class);
    }

    private TestCase getTestCaseById(Long id){
        return iTestCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("TestCase id: " + id + " not found!"));
    }
    public MessageDto delete(Long id){
        iTestCaseRepository.delete(getTestCaseById(id));
        return new MessageDto("TestCase id: " + id + " has been removed");
    }
    public  TestCaseResponseDto findById(Long id){
        TestCase testCase = getTestCaseById(id);
        return Mapper.getMapper().map(testCase,TestCaseResponseDto.class);
    }
    public List<TestCaseResponseDto> findAll(String lastUpdate){
        if(lastUpdate.isEmpty())
            return iTestCaseRepository.findAll().stream().map(t -> Mapper.getMapper().map(t,TestCaseResponseDto.class)).toList();

        List<TestCase> testCaseList = iTestCaseRepository.findAll().stream().filter(t -> t.getLastUpdate().isAfter(LocalDate.parse(lastUpdate,formatter))).toList();
        return testCaseList.stream().map(t -> Mapper.getMapper().map(t,TestCaseResponseDto.class)).toList();
    }

    //Solo para ve si funciona el query :D OwO
    public List<TestCaseResponseDto> findByDateQuery(String lastUpdate){
        if(!lastUpdate.isEmpty()){
            List<TestCase> testFiltered = iTestCaseRepository.findTestByDate(lastUpdate);
            return testFiltered.stream().map(t -> Mapper.getMapper().map(t,TestCaseResponseDto.class)).toList();
        }else{
            throw new NotFoundException("Date not value");
        }
    }
    public TestCaseResponseDto update(Long id, TestCaseRequestDTO testCaseRequestDTO){
        if (!iTestCaseRepository.existsById(id)) throw new NotFoundException("TestCase id: " + id + " not found!");
        TestCase testCase = Mapper.getMapper().map(testCaseRequestDTO,TestCase.class);
        iTestCaseRepository.save(testCase);
        return Mapper.getMapper().map(testCase,TestCaseResponseDto.class);
    }



}
