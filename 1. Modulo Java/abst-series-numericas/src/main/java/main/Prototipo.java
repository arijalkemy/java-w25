package main;

import java.util.List;

public abstract class Prototipo {

    private List<Number> serieNumerica;

    public abstract Number numeroSiguiente();
    public abstract void reiniciarSerie();
    public abstract void establecerValorInicial(Number number);

}
