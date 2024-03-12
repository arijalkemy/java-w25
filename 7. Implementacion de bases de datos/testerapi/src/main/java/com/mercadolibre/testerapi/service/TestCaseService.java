package com.mercadolibre.testerapi.service;

import com.mercadolibre.testerapi.Exception.NotFoundException;
import com.mercadolibre.testerapi.dto.MessageDto;
import com.mercadolibre.testerapi.dto.TestCaseDto;
import com.mercadolibre.testerapi.model.TestCase;
import com.mercadolibre.testerapi.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService{


    ITestCaseRepository testRepo;
    public TestCaseService(ITestCaseRepository testRepo){
        this.testRepo = testRepo;
    }

    @Override
    public List<TestCaseDto> getAll() {
        List<TestCase> listTEst = testRepo.findAll();
        List<TestCaseDto> listTestDto = new ArrayList<>();

        for (TestCase test : listTEst)
        {
            listTestDto.add( TestCaseDto.builder()
                            .idCase(test.getIdCase())
                            .tested(test.getTested())
                            .passed(test.getPassed())
                            .numbreOfTries(test.getNumbreOfTries())
                            .description(test.getDescription())
                            .lastUpdate(test.getLastUpdate())
                    .build());
        }

        return listTestDto;
    }

    @Override
    public TestCaseDto getById(Long id) {
        Optional<TestCase> result = testRepo.findById(id);
        if(result.isPresent()) {
            TestCase aux = result.get();
            return TestCaseDto.builder()
                    .idCase(aux.getIdCase())
                    .description(aux.getDescription())
                    .tested(aux.getTested())
                    .passed(aux.getPassed())
                    .lastUpdate(aux.getLastUpdate())
                    .build();
        }
        else
            throw new NotFoundException("Id Not Found");

    }

    @Override
    public MessageDto save(TestCaseDto test) {
        TestCase testEntity = TestCase.builder()
                .idCase(test.getIdCase())
                .description(test.getDescription())
                .tested(test.getTested())
                .passed(test.getPassed())
                .numbreOfTries(test.getNumbreOfTries())
                .lastUpdate(test.getLastUpdate())
                        .build();

        TestCase result = testRepo.save(testEntity);
        String message =result != null ? "Test Agregado": "errpr";
        return MessageDto.builder()
                .message(message)
                .build();
    }

    @Override
    public MessageDto update(Long id, TestCaseDto testCase) {
        if(testRepo.findById(id).isPresent()){
            testCase.setIdCase(id);
             MessageDto result= save(testCase);
             if(!result.getMessage().equalsIgnoreCase("error"))
                 result.setMessage("Update Successfully");
             return result;
        }
        else
            throw new NotFoundException("Id not found update");
    }

    @Override
    public MessageDto deleteById(Long id) {
        if(testRepo.findById(id).isPresent()){
            testRepo.deleteById(id);
            return MessageDto.builder()
                    .message("Test Delete")
                    .build();

        }
        else
            throw new NotFoundException("Id not found To Delete");
    }

    @Override
    public List<TestCaseDto> findByDate(String date) {
        return null;
    }
}
