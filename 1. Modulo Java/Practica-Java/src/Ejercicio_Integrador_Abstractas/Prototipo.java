package Ejercicio_Integrador_Abstractas;

public class Prototipo {
    protected Integer seriesType;
    protected Integer value;
    protected Integer originalValue;

    public Prototipo(Integer seriesType, Integer value) {
        this.value = value;
        this.originalValue = value;
        this.seriesType = seriesType;
    }

    public void setInitialValue(Integer value) {
        this.value = value;
    }

    public void resetValue() {
        this.value = this.originalValue;
    }

    private void addValue() {
        this.value += this.seriesType;
    }

    public Integer nextValue() {
        addValue();
        return this.value;
    }
}
