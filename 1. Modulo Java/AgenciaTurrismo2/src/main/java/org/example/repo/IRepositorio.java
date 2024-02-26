package org.example.repo;

import java.util.List;

public interface IRepositorio<T>{
    List<T> getList();
    void add(T t);
}
