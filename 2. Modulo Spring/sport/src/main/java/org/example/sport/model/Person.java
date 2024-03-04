package org.example.sport.model;

public class Person {
    private String name;
    private String lastName;
    private short Age;

    public Person(String name, String lastName, short age) {
        this.name = name;
        this.lastName = lastName;
        Age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public short getAge() {
        return Age;
    }
}
