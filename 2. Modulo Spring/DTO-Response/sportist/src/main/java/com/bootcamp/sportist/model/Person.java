package com.bootcamp.sportist.model;

import java.util.List;

public class Person {

    private String name;
    private String lastName;
    private Integer age;
    private List<Sport> sportsList;

    public Person(String name, String lastName, Integer age, List<Sport> sportsList) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sportsList = sportsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Sport> getSport() {
        return sportsList;
    }

    public void setSport(List<Sport> sportsList) {
        this.sportsList = sportsList;
    }
}
