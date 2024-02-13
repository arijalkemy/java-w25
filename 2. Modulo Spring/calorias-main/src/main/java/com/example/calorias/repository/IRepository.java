package com.example.calorias.repository;

import java.util.List;

public interface IRepository <E> {
    List<E> findAll();
}
