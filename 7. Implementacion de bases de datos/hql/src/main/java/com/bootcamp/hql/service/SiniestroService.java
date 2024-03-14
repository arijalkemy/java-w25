package com.bootcamp.hql.service;

import com.bootcamp.hql.model.Siniestro;
import com.bootcamp.hql.repository.interfaces.ISiniestroRepository;
import com.bootcamp.hql.service.interfaces.ISiniestroService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class SiniestroService implements ISiniestroService {
    ISiniestroRepository siniestroRepository;
    public SiniestroService(ISiniestroRepository siniestroRepository){
        this.siniestroRepository = siniestroRepository;
        //loadData();
    }
    private void loadData(){
        List<Siniestro> listaSiniestros = new ArrayList<>(
                Arrays.asList(
                        new Siniestro(null, LocalDate.of(2022, 1, 1), 1000.00),
                        new Siniestro(null,LocalDate.of(2022, 2, 15), 2000.00),
                        new Siniestro(null,LocalDate.of(2022, 2, 15), 2000.00)
                )
        );
        siniestroRepository.saveAll(listaSiniestros);
    }
}
