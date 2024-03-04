package org.example.sport.repository.impl;

import org.example.sport.model.Person;
import org.example.sport.repository.common.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class PersonRepository implements IRepository<Person,Integer> {
    ArrayList<Person> persons = new ArrayList<Person>() {{
        add(new Person("John1", "Doe1", (short) 21));
        add(new Person("John2", "Doe2", (short) 22));
        add(new Person("John3", "Doe3", (short) 23));
        add(new Person("John4", "Doe4", (short) 24));
        add(new Person("John5", "Doe5", (short) 25));
        add(new Person("John6", "Doe6", (short) 26));
        add(new Person("John7", "Doe7", (short) 27));
        add(new Person("John8", "Doe8", (short) 28));
        add(new Person("John9", "Doe9", (short) 29));
        add(new Person("John10", "Doe10", (short) 30));
        add(new Person("John11", "Doe11", (short) 31));
        add(new Person("John12", "Doe12", (short) 32));
        add(new Person("John13", "Doe13", (short) 33));
        add(new Person("John14", "Doe14", (short) 34));
        add(new Person("John15", "Doe15", (short) 35));
        add(new Person("John16", "Doe16", (short) 36));
        add(new Person("John17", "Doe17", (short) 37));
        add(new Person("John18", "Doe18", (short) 38));
        add(new Person("John19", "Doe19", (short) 39));
        add(new Person("John20", "Doe20", (short) 40));
    }};
    @Override
    public ArrayList<Person> getAll() {
        return this.persons;
    }
}
