package models;

import java.util.ArrayList;

public class Curriculum {
    String name;

    String lastname;

    int age;

    List<String> skills = new ArrayList<>();

    public Curriculum(String name, String lastname, int age, List<String> skills) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.skills = skills;
    }
}
