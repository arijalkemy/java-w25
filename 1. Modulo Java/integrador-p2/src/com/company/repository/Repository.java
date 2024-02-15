package com.company.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    boolean add(T t);
    List<T> findAll();
    Optional<T> findById(String id);
    //REMOVE

}
