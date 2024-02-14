package com.COVID19.COVID19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {
    private String code;
    private String name;
    private String gravityLevel;

    public Symptom(String code, String name, String gravityLevel) {
        this.code = code;
        this.name = name;
        this.gravityLevel = gravityLevel;
    }
}
