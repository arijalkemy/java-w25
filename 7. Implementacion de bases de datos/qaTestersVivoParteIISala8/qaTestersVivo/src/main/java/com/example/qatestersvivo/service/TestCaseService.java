package com.example.qatestersvivo.service;

import com.example.qatestersvivo.entity.TestCase;
import com.example.qatestersvivo.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    private ITestCaseRepository repository;

    @Override
    public TestCase create(TestCase obj) {
        return this.repository.save(obj);
    }

    @Override
    public List<TestCase> findAll() {
        return  this.repository.findAll();
    }

    @Override
    public TestCase getById(Long id) {

        return this.repository.findById(id).orElse(null);
    }

    @Override
    public TestCase updateById(Long id, TestCase obj) {
        TestCase test = repository.findById(id).orElse(null);

        if(test!=null){
            obj.setId(id);
           return repository.save(obj);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
