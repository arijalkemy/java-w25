package org.example.sport.repository.common;

import java.util.ArrayList;

public interface IRepository<Entity,Id> {
    public ArrayList<Entity> getAll();
}
