package org.example;

import java.util.List;

public abstract class Prototype {

    protected Integer currentNumber;

    public abstract Integer getNextNumber();

    public void resetSeries() {
        currentNumber = null;
    }

    public void setInitialValue(Integer initialValue) {
        currentNumber = initialValue;
    }
}
