package com.example.testerapi.service;

import com.example.testerapi.dtos.TestRequestdto;
import com.example.testerapi.dtos.TestResponsedto;
import com.example.testerapi.model.TestCase;
import com.example.testerapi.repository.ITestCaseRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCase{
    public ITestCaseRepository TestCaserepo;
    public ModelMapper modelMapper;

    public TestCaseService(ITestCaseRepository testCaserepo){
        this.TestCaserepo = testCaserepo;
        this.modelMapper = new ModelMapper();
    }
    @Transactional
    public List<TestResponsedto> getAll() {
        return TestCaserepo.findAll().stream().map(t -> modelMapper.map(t, TestResponsedto.class)).toList();
    }

    @Transactional
    public TestResponsedto saveTestCase(TestRequestdto testCase) {
        if(testCase.getLast_update()==null){
            testCase.setLast_update(LocalDate.now());
        }
        TestCase createdtest = TestCaserepo.save(modelMapper.map(testCase,TestCase.class));
        return modelMapper.map(createdtest,TestResponsedto.class);
    }

    @Override
    @Transactional
    public TestCase DeleteTestCase(Long id) {
        TestCase testCase = TestCaserepo.findById(id).orElse(null);
        if(testCase !=null) {
            TestCaserepo.deleteById(id);
            return testCase;
        }
        return null;
    }

    @Transactional
    public TestResponsedto findTestCase(Long id) throws BadRequestException {
        return modelMapper.map(TestCaserepo.findById(id).orElseThrow(()->new BadRequestException("el id no es valido capo")),TestResponsedto.class);
    }

    @Override
    public TestRequestdto updateTestCase(TestRequestdto requestdto,Long id) throws BadRequestException {
        TestCase testCase = TestCaserepo.findById(id).orElseThrow(()->new BadRequestException("el id no es valido capo"));
        TestCase updatedTestCase = modelMapper.map(requestdto,TestCase.class);
        updatedTestCase.setId_case(id);
        TestCaserepo.save(updatedTestCase);
        return requestdto;
    }

//    @Override
//    @Transactional
//    public TestCase updateTestCase(Long id) {
//
//    }

    @Override
    @Transactional
    public List<TestCase> getTestCasesByDate(LocalDate date) {
        return TestCaserepo.findAll().stream().filter(t -> t.getLast_update().isAfter(date)).toList();
    }


}
