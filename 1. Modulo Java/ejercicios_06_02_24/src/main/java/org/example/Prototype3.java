package org.example;

public class Prototype3 extends Prototype {

    public Prototype3() {
        this.currentNumber = 0;
    }

    @Override
    public Integer getNextNumber() {
        this.currentNumber += 3;
        return this.currentNumber;
    }

    @Override
    public void setInitialValue(Integer initialValue) {
        super.setInitialValue(initialValue);
    }
}
