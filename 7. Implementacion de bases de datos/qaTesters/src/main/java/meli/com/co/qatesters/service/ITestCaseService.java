package meli.com.co.qatesters.service;

import meli.com.co.qatesters.dto.request.CreateCaseDto;
import meli.com.co.qatesters.dto.request.UpdateCaseDto;
import meli.com.co.qatesters.dto.response.MessageDto;
import meli.com.co.qatesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public CreateCaseDto crear(CreateCaseDto createCaseDto);
    public MessageDto updateCase(Long id, UpdateCaseDto caseDto);
    public List<TestCase> getAllTestCases();
    public TestCase getByLastUpdate(LocalDate date);
    public String deleteCase(Long id);
}
