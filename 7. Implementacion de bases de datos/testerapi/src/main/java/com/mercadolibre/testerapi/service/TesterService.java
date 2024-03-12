package com.mercadolibre.testerapi.service;

import com.mercadolibre.testerapi.Exception.NotFoundException;
import com.mercadolibre.testerapi.Util.MapperUtil;
import com.mercadolibre.testerapi.dto.MessageDto;
import com.mercadolibre.testerapi.dto.TesterDto;
import com.mercadolibre.testerapi.model.TestCase;
import com.mercadolibre.testerapi.model.Tester;
import com.mercadolibre.testerapi.repository.ITestCaseRepository;
import com.mercadolibre.testerapi.repository.ITesterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesterService implements ITesterService{
    ITesterRepository testerRepository;
    ModelMapper  mapperUtil;
    public TesterService(ITesterRepository testerRepository,ModelMapper modelMapper){
        this.testerRepository = testerRepository;
        this.mapperUtil =modelMapper;
    }

    @Override
    public MessageDto save(TesterDto testerDto) {
        Tester tester = Tester.builder()
                .idTester(testerDto.getIdTester())
                .nombre(testerDto.getNombre())
                .apellido(testerDto.getApellido())
                .build();
        tester.setListTests(testerDto.getListTests().forEach(x -> mapperUtil.map(x, TestCase.class)));

        Tester result = testerRepository.save(tester);
        String message = result != null ? "Test Agregado": "errpr";
        return MessageDto.builder()
                .message(message)
                .build();
    }

    @Override
    public MessageDto deleteById(Long id) {
        testerRepository.findById(id).orElseThrow(NoClassDefFoundError::new);
        testerRepository.deleteById(id);
        return MessageDto.builder()
                .message("Tester eliminado")
                .build();
    }

    /*
    @Override
    public TesterDto findTesterById(Long id); {
        return  null;
    }*/

}
