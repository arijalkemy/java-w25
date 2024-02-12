package org.example.repository;

import java.util.List;

public interface ICrudRepository<T> {
    boolean add(T newItem);
    boolean update(T newItem, String id);
    boolean deleteById(String id);
    T findById(String id);
    List<T> findAll();
}
