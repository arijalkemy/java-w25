package com.COVID19.COVID19.repository;

import com.COVID19.COVID19.model.Symptom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class SymtomsRepository {
    private List<Symptom> syntoms = Arrays.asList(
            new Symptom("AB212","Fiebre","leve"),
            new Symptom("BC321","Gripe","leve"),
            new Symptom("LJ313","Dolor de cabeza","medio"),
            new Symptom("VP216","Vomito","grave"),
            new Symptom("PP134","Perdida de consiencia","critico")
    );

    public List<Symptom> getSymptoms() {
        return syntoms;
    }

}
