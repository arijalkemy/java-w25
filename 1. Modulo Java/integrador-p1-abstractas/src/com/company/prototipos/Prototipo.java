package com.company.prototipos;

public interface Prototipo<T extends Number>{

    T nextValue();
    void restart();
    void setInitValue(T initValue);


}
