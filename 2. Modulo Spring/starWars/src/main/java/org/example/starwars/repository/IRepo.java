package org.example.starwars.repository;

import java.util.List;

public interface IRepo<T> {
    List<T> findAll();
    void add(T t);
    void cargar();
}
