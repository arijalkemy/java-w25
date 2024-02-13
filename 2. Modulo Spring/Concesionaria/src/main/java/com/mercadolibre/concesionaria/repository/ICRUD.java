package com.mercadolibre.concesionaria.repository;

import java.util.List;

public interface ICRUD <T,U>{

    List<T> getAll();
    List<T> getByDates(String since, String to);
    List<T> getByPrices(Integer since, Integer to);
    T getById(U id);

    void add(T car);

}
