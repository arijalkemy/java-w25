package com.COVID19.COVID19.service;

import com.COVID19.COVID19.model.Symptom;

import java.util.List;

public interface ISymptomService {
    public List<Symptom> getAllSymptoms();
    public Symptom getSymptomForName(String name);
}
