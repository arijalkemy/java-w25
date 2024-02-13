package com.bootcamp.sportist;

import com.bootcamp.sportist.model.Person;
import com.bootcamp.sportist.model.Sport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SportistApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportistApplication.class, args);
    }

    public static List<Sport> getSportsList(){
        List<Sport> sportList = new ArrayList<>();
        sportList.add(new Sport("Football", "Low"));
        sportList.add(new Sport("Basketball", "Low"));
        sportList.add(new Sport("Baseball", "Medium"));
        sportList.add(new Sport("Taekwondo", "High"));
        sportList.add(new Sport("Chess", "Low"));

        return sportList;
    }

    public static List<Person> getPersonsList(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepe", "Perez", 34, getSportsList().subList(0,2)));
        personList.add(new Person("Andres", "Ramirez", 23, getSportsList().subList(1,4)));
        personList.add(new Person("Maria", "Antonieta", 21, getSportsList().subList(0,1)));
        personList.add(new Person("Andrea", "Torres", 28, getSportsList().subList(2,5)));
        personList.add(new Person("Nicanor", "Spuckler", 12, getSportsList().subList(0,4)));

        return personList;
    }
}
