package com.example.startwars.repository;

import java.util.List;

public interface IRepository<T> {

  List<T> getAll();
}
