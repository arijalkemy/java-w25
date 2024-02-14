package com.clase09_02_24.ejerciciocovid.controller;

import com.clase09_02_24.ejerciciocovid.dto.PersonaDeRiesgoDTO;
import com.clase09_02_24.ejerciciocovid.entity.Sintoma;
import com.clase09_02_24.ejerciciocovid.service.SintomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class sintomaController {
    @Autowired
    SintomasService sintomasService;

    @GetMapping("/findSymptom")
    public List<Sintoma> findSymptom(){
        return sintomasService.getAllSintomas();
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDeRiesgoDTO> findRiskPerson(){
        return sintomasService.getAllPersonaDeRiesgo();
    }
}
