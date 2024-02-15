package com.company.prototipos;

public class Serie2Impl<T extends Number> implements Prototipo{

    private Number value;
    private Number increment;

    @Override
    public Number nextValue() {
        return null;
    }

    @Override
    public void restart() {

    }

    @Override
    public void setInitValue(Number initValue) {
        this.value = initValue;
    }
}
