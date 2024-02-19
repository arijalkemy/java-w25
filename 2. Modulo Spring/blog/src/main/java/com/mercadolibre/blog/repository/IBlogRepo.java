package com.mercadolibre.blog.repository;

import java.util.List;
import java.util.Map;

public interface IBlogRepo <T, U> {
    Map<U,T> getAll();
    void add(U id, T t);
    T getById(U u);

}
