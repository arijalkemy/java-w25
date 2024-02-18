package org.example.ejercicio2.clases;

import java.util.ArrayList;
import java.util.List;

public class Resume extends Document{
    Person person;
    List<String> skills;

    public Resume(Person person) {
        this.person = person;
        this.skills = new ArrayList<>();
    }

    public void addSkills(String newSkills) {
        skills.add(newSkills);
    }

    @Override
    public void print() {
        super.printFileType();
        System.out.println("Person: " + this.person);
        System.out.println("Skills: " + this.skills);
    }
}
