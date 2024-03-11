package com.implementacionbasedatos.ejercicio1.service;

import java.util.List;

import com.implementacionbasedatos.ejercicio1.dto.req.TestCaseReqDTO;
import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDTO;
import com.implementacionbasedatos.ejercicio1.dto.res.TestCaseResDTO;

public interface ITestCaseService {

    public List<TestCaseResDTO> getTestCase();

    public MessageResDTO postTestCase(TestCaseReqDTO testCaseReqDTO);

    public MessageResDTO deleteTestCase(long id);

    public TestCaseResDTO getTestCaseById(long id);

    public TestCaseResDTO putTestCase(Long id, TestCaseReqDTO testCaseReqDTO);

}
