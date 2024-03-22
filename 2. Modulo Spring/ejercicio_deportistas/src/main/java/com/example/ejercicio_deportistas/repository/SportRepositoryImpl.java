package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SportRepositoryImpl implements ISportRepository{

    private static final List<Sport> sportList = new ArrayList<>(List.of(new Sport("Tenis", 1), new Sport("Voley", 2), new Sport("Rugby", 3)));

    @Override
    public List<Sport> findAll() {
        return sportList;
    }

    @Override
    public Optional<Sport> findByName(String name) {
        return sportList.stream().filter(sport -> Objects.equals(sport.getName(), name)).findFirst();
    }
}
