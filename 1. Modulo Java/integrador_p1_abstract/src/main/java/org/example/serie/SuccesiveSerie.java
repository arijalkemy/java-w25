package org.example.serie;

public abstract class SuccesiveSerie <T extends Number> {
    protected T initialValue;
    protected T currentValue;

    public void setInitialValue(T initialValue) {
        this.initialValue = initialValue;
        resetCurrentValue();
    }

    public T getCurrentValue() {
        return currentValue;
    }

    public abstract T nextValue();
    public void resetCurrentValue(){
        currentValue = initialValue;
    }
}
