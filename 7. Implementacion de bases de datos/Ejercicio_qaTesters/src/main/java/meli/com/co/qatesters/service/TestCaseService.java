package meli.com.co.qatesters.service;

import meli.com.co.qatesters.dto.request.CreateCaseDto;
import meli.com.co.qatesters.dto.request.UpdateCaseDto;
import meli.com.co.qatesters.dto.response.MessageDto;
import meli.com.co.qatesters.entity.TestCase;
import meli.com.co.qatesters.exception.NotFoundException;
import meli.com.co.qatesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    ModelMapper mapper = new ModelMapper();

    private final TestCaseRepository caseRepository;

    public TestCaseService(TestCaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public CreateCaseDto crear(CreateCaseDto createCaseDto) {
        return mapper.map(caseRepository.save(mapper.map(createCaseDto, TestCase.class)), CreateCaseDto.class);
    }

    @Override
    public MessageDto updateCase(Long id, UpdateCaseDto caseDto) {
        Optional<TestCase> caseOpt = caseRepository.findById(id);
        if(caseOpt.isEmpty()) throw new NotFoundException("No se ha encontrado un TestCase con ese id.");

        TestCase testCase = caseOpt.get();
        if(caseDto.getTested() != null) testCase.setTested(caseDto.getTested());
        if(caseDto.getPassed()!= null) testCase.setPassed(caseDto.getPassed());
        if(caseDto.getDescription() != null) testCase.setDescription(caseDto.getDescription());
        if(caseDto.getNumberOfTries() != null) testCase.setNumberOfTries(caseDto.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.now());
        caseRepository.save(testCase);
        return new MessageDto("Se ha actualizado correctamente el TestCase. ID: " + testCase.getId());
    }
    @Override
    public String deleteCase(Long id){
        Optional<TestCase> caseOptional = caseRepository.findById(id);
        if (caseOptional.isEmpty()){
            throw new NotFoundException("No se ha encontrado un TestCase con ese id.");
        }
        caseRepository.deleteById(id);
        return ("El TestCase fue eliminado exitosamente.");
    }

    @Override
    public TestCase getByLastUpdate(LocalDate date){
        List<TestCase> allCases = caseRepository.findAll();
        return allCases.stream().filter(testCase -> testCase.getLastUpdate().equals(date)).findFirst().orElseThrow();
    }

    @Override
    public List<TestCase> getAllTestCases() {
        return caseRepository.findAll();
    }
}
