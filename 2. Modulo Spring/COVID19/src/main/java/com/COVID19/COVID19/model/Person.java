package com.COVID19.COVID19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private List<Symptom> syntoms;

    public Person(int id, String firstName, String lastName, int age, List<Symptom> syntoms) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.syntoms = syntoms;
    }
}
