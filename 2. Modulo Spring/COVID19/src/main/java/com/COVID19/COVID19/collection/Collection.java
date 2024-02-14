package com.COVID19.COVID19.collection;

import com.COVID19.COVID19.dto.RiskPersonDto;
import com.COVID19.COVID19.model.Symptom;
import com.COVID19.COVID19.service.PersonServiceImp;
import com.COVID19.COVID19.service.SymptomServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class Collection {

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> findSymptom(){
        SymptomServiceImp symptomService = new SymptomServiceImp();
        return new ResponseEntity<>(symptomService.getAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Symptom> findSymptomForName(@PathVariable String name){
        SymptomServiceImp symptomService = new SymptomServiceImp();
        Symptom symptom = symptomService.getSymptomForName(name);
        return new ResponseEntity<>(symptom, HttpStatus.OK);

    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDto>> findRiskPerson(){
        PersonServiceImp personService = new PersonServiceImp();
        List<RiskPersonDto> riskPersons = personService.getRiskPersons();
        return new ResponseEntity<>(riskPersons, HttpStatus.OK);
    }
}
