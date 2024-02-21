package com.dto.deportistas.repository;

import java.util.List;

public interface IGenericRepository<T>{
    public List<T> getLista();
}
