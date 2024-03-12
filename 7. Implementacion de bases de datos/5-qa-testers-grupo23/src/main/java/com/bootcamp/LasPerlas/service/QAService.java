package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.ResponseDto;
import com.bootcamp.LasPerlas.dto.TestCaseDto;
import com.bootcamp.LasPerlas.exceptions.TestNotFoundException;
import com.bootcamp.LasPerlas.model.TestCase;
import com.bootcamp.LasPerlas.repository.IQARepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QAService implements IQAService {
    @Autowired
    IQARepository testsRepo;

    @Override
    public ResponseDto saveTest(TestCaseDto testNuevo) {
        ModelMapper modelExample = new ModelMapper();
        TestCase test1 = modelExample.map(testNuevo, TestCase.class);
        testsRepo.save(test1);
        return new ResponseDto(testNuevo.getId_case(),"Todo piola");
    }

    @Override
    public List<TestCaseDto> getTests() {
        ModelMapper mapper = new ModelMapper();
        List<TestCase> tests = testsRepo.findAll();
        return tests.stream().map(testCase -> mapper.map(testCase, TestCaseDto.class)).collect(Collectors.toList());
    }

    @Override
    public TestCaseDto findTest(Long id) {
        ModelMapper mapper = new ModelMapper();
        //el orElseThrow nos permite devolver una exception en caso de no encontrar el test
        TestCase testCase = testsRepo.findById(id).orElseThrow(() -> new TestNotFoundException("No se encontro el test"));
        return mapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public ResponseDto deleteTest(Long id) {
        //Borrado lógico
        Optional<TestCase> testOriginal = testsRepo.findById(id);
        if(testOriginal.isEmpty()) throw new TestNotFoundException("No se encontró el test");
        testOriginal.get().setIs_active(false);

        return new ResponseDto(id, "El test ha sido borrado correctamente");
    }

    @Override
    public ResponseDto editTest(Long id, TestCaseDto test) {
        ModelMapper mapper = new ModelMapper();
        TestCase testOriginal = testsRepo.findById(id).orElseThrow(() -> new TestNotFoundException("No se encontro el test"));

        testOriginal.setDescription(test.getDescription());
        testOriginal.setTested(test.getTested());
        testOriginal.setPassed(test.getPassed());
        testOriginal.setNumber_of_tries(test.getNumber_of_tries());
        testOriginal.setLast_update(LocalDate.now());

        TestCaseDto testOriginalDto = mapper.map(testOriginal, TestCaseDto.class);
        this.saveTest(testOriginalDto);
        return new ResponseDto(id, "Registro modificado correctamente.");

    }
}
