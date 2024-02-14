package com.COVID19.COVID19.service;

import com.COVID19.COVID19.dto.RiskPersonDto;
import com.COVID19.COVID19.model.Symptom;
import com.COVID19.COVID19.repository.SymtomsRepository;

import java.util.List;

public class SymptomServiceImp implements ISymptomService{

    private SymtomsRepository symtomsRepository = new SymtomsRepository();


    public List<Symptom> getAllSymptoms(){
        return symtomsRepository.getSymptoms();
    }

    public Symptom getSymptomForName(String name){
        List<Symptom> symptoms = symtomsRepository.getSymptoms();
        for(Symptom symptom: symptoms){
            if(symptom.getName().equals(name)){
                return symptom;
            }
        }
        return null;
    }


}
