package org.example.exercise2.impl;

import org.example.exercise2.Document;

import java.util.List;

public class Curriculum extends Document {
    public Curriculum(Person person, List<String> abilities) {
        this.person = person;
        this.abilities = abilities;
    }

    private Person person;
    private List<String> abilities;
    @Override
    public void print() {
        System.out.println("CURRICULUM VITAE");
        System.out.println(person.toString());
        abilities.forEach(System.out::println);
    }
}
