package org.bootcamp.ejercicio2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Curriculum extends Document {
    private Person person;
    private List<String> skillList;

    public Curriculum(String typeDocument, Person person, List<String> skillList) {
        super(typeDocument);
        this.person = person;
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "person=" + person +
                ", skillList=" + skillList +
                ", typeDocument='" + typeDocument + '\'' +
                '}';
    }
}
