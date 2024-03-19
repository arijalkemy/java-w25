package main;

import java.util.ArrayList;
import java.util.List;

public class SerieNumericaUno extends Prototipo{

    private List<Number> serieNumerica;

    public SerieNumericaUno() {
        this.serieNumerica = new ArrayList<>();
    }

    public List<Number> getSerieNumerica() {
        return serieNumerica;
    }

    public void setSerieNumerica(List<Number> serieNumerica) {
        this.serieNumerica = serieNumerica;
    }

    @Override
    public Number numeroSiguiente() {
        if(this.serieNumerica.isEmpty()){
            this.serieNumerica.add(0);
        }else{
            this.serieNumerica.add(serieNumerica.get(serieNumerica.size() - 1).intValue() + 2);
        }
        return getSerieNumerica().get(serieNumerica.size() - 1);
    }

    @Override
    public void reiniciarSerie() {
        this.serieNumerica = null;
    }

    @Override
    public void establecerValorInicial(Number number) {
        if(this.serieNumerica.isEmpty()){
            this.serieNumerica.add(number);
        }else{
            System.out.println("La serie ya esta inicializada");
        }
    }
}
