package org.abstractFactoryPattern.repository;

public interface AbstractFactory<T> {
    T create (String type);
}
