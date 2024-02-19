package com.mercadolibre.linktracker.repository;

import java.util.Map;

public interface ILinkRepo  <T,U>{
    Map<U,T> getAll();
    T getById(U id, String password);

    T getById(U id);
    U add(T t);

    void disable(U id);

}
