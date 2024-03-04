package org.example.sport.repository.impl;

import org.example.sport.enums.EnumSportLevel;
import org.example.sport.model.Sport;
import org.example.sport.repository.common.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Random;

@Repository
public class SportRepository implements IRepository<Sport,Integer> {
    private final ArrayList<Sport> sports;


    public SportRepository(){
        this.sports = new ArrayList<>();
        String[] sportNames = {"Football", "Basketball", "Tennis", "Swimming", "Cycling", "Volleyball", "Baseball"};
        for (String name:sportNames) this.sports
                .add(new Sport(name,EnumSportLevel.values()[new Random()
                        .nextInt(EnumSportLevel.values().length-1)]));

    }
    @Override
    public ArrayList<Sport> getAll() {
        return this.sports;
    }
}
