package com.example.qatestersvivo.service;

import com.example.qatestersvivo.entity.TestCase;

import java.util.List;

public interface ITestCaseService {

    public TestCase create(TestCase obj);
    public List<TestCase> findAll();
    public TestCase getById(Long id);
    public TestCase updateById(Long id, TestCase obj);
    public void deleteById(Long id);



}
