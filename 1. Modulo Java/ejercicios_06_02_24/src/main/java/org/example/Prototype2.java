package org.example;

public class Prototype2 extends Prototype {

    public Prototype2() {
        this.currentNumber = 0;
    }

    @Override
    public Integer getNextNumber() {
        this.currentNumber += 2;
        return this.currentNumber;
    }

    @Override
    public void setInitialValue(Integer initialValue) {
        super.setInitialValue(initialValue);
    }
}
